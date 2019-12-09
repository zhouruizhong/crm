package com.zrz.crm.service;

import com.zrz.crm.config.RedisUtil;
import com.zrz.crm.enums.CodeTypeEnum;
import com.zrz.crm.enums.DeleteFlagEnum;
import com.zrz.crm.mapper.*;
import com.zrz.crm.model.*;
import com.zrz.crm.service.bo.UserBo;
import com.zrz.crm.utils.AssertUtil;
import com.zrz.crm.utils.CodecUtil;
import com.zrz.crm.utils.RegexUtil;
import com.zrz.crm.web.config.advice.ExceptionEnum;
import com.zrz.crm.web.config.session.SessionUtil;
import com.zrz.crm.web.dto.UserDto;
import com.zrz.crm.web.param.LoginParam;
import com.zrz.crm.web.param.UserParam;
import com.zrz.crm.web.param.UserUpdateParam;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * @author zrz
 * @desc 描述信息
 * @date 2019/9/28
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserOrgMapper userOrgMapper;

    @Resource
    private UserDeptMapper userDeptMapper;

    @Resource
    private UserPositionMapper userPositionMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private OrgService orgService;

    @Resource
    private ValidService validService;

    UserBo getUserByPhone(String phone) {
        return userMapper.getUserByPhone(phone);
    }

    public UserDto login(LoginParam loginParam) {
        String phone = loginParam.getPhone();
        String password = loginParam.getPassword();

        AssertUtil.hasLength(phone, ExceptionEnum.NotNullPhone);
        AssertUtil.hasLength(password, ExceptionEnum.NotNullPassword);

        UserBo user = getUserByPhone(phone);
        AssertUtil.notNull(user, ExceptionEnum.InValidUser);

        AssertUtil.isTrue(Objects.equals(user.getPassword(), CodecUtil.generateEncryptPassword(password, user.getSalt(), false)),
                ExceptionEnum.IncorrectNameOrPassword);

        String token = CodecUtil.getMD5Cryptography(String.join("|", user.getPhone(), user.getId().toString()));
        SessionUtil.save(token, user);

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);

        userDto.setToken(token);

        return userDto;
    }

    @Transactional(rollbackFor = Exception.class)
    public void resetPassword(String phone, String code, String password) {
        AssertUtil.isTrue(RegexUtil.checkPhone(phone), ExceptionEnum.IncorrectPhone);

        UserBo user = getUserByPhone(phone);
        AssertUtil.notNull(user, ExceptionEnum.InValidUser);

        validService.validCode(code, phone, CodeTypeEnum.ChangePassword);


        String salt = RandomStringUtils.randomAlphabetic(6);
        String encryptPassword = CodecUtil.generateEncryptPassword(password, salt, false);

        User newUser = new User();
        newUser.setSalt(salt);
        newUser.setPassword(encryptPassword);
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id", user.getId());
        userMapper.updateByExampleSelective(newUser, example);

        String token = CodecUtil.getMD5Cryptography(String.join("|", user.getPhone(), user.getId().toString()));
        SessionUtil.delete(token);
    }

    public void update(UserUpdateParam userParam, Integer userId) {
        User user = new User();
        user.setId(userId);
        user.setName(userParam.getName());
        user.setEmail(userParam.getEmail());
        user.setPortrait(userParam.getPortrait());
        user.setSex(userParam.getSex());

        userMapper.updateByPrimaryKeySelective(user);
    }

    public User getUserByMobile(String mobile) {
        User user = new User();
        user.setName(mobile);
        user.setDeleteFlag(DeleteFlagEnum.NOT_DELETED.getCode());
        return userMapper.selectOne(user);
    }

    public User getUserByName(String name) {
        User user = new User();
        user.setName(name);
        user.setDeleteFlag(DeleteFlagEnum.NOT_DELETED.getCode());
        return userMapper.selectOne(user);
    }

    public void checkParam(UserParam userParam){
        // 验证用户名是否存在
        //User user = getUserByName(userParam.getName());
        //AssertUtil.isTrue(user == null, ExceptionEnum.ExistsUser);

        // 验证手机号是否存在
        User user = getUserByMobile(userParam.getMobile());
        AssertUtil.isTrue(user == null, ExceptionEnum.PhoneAlreadyRegister);

        // 验证邮箱是否存在
        //user = getUserByEmail(userParam.getEmail());
        //AssertUtil.isTrue(user == null, ExceptionEnum.EmailAlreadyRegister);
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(UserDto user, UserParam userParam) {
        // 验证参数
        checkParam(userParam);

        User record = new User();
        BeanUtils.copyProperties(userParam, record);
        String salt = RandomStringUtils.randomAlphabetic(6);
        //String encryptPassword = CodecUtil.generateEncryptPassword(userParam.getPwd(), salt, false);
        //record.setPwd(encryptPassword);
        record.setSalt(salt);
        // TODO 用户编号
        //record.setCode("");
        //record.setNationalCode("CN");
        //record.setTelephone(userParam.getMobile());
        //record.setRemark(user.getOrgName() + " " +user.getName() + "新增");
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        //record.setLastLoginTime(new Date());
        //record.setDeleteFlag(DeleteFlagEnum.NOT_DELETED_VALUE);
        //record.setLocked((byte)1);
        userMapper.insertUseGeneratedKeys(record);

        // 单位
        UserOrg userOrg = new UserOrg();
        userOrg.setUserId(record.getId());
        //userOrg.setOrgId(userParam.getOrgId());
        userOrgMapper.insertSelective(userOrg);

        // 部门
        UserDept userDept = new UserDept();
        //userDept.setDeptId(userParam.getDeptId());
        userDept.setUserId(record.getId());
        userDeptMapper.insert(userDept);

        // 职位
        UserPosition userPosition = new UserPosition();
        //userPosition.setPositionId(userParam.getPositionId());
        userPosition.setUserId(record.getId());
        userPositionMapper.insert(userPosition);

        // 角色
        UserRole userRole = new UserRole();
        // 干线公司
        //userRole.setRoleId(roleId);
        userRole.setUserId(record.getId());
        userRoleMapper.insert(userRole);
    }
}
