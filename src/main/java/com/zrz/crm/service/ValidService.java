package com.zrz.crm.service;

import com.zrz.crm.config.RedisUtil;
import com.zrz.crm.enums.CodeTypeEnum;
import com.zrz.crm.service.bo.UserBo;
import com.zrz.crm.utils.AssertUtil;
import com.zrz.crm.utils.RegexUtil;
import com.zrz.crm.utils.SmsUtil;
import com.zrz.crm.web.config.advice.ExceptionEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zrz
 * @desc 描述信息
 * @date 2019/9/28
 */
@Service
public class ValidService {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private UserService userService;

    public void validPhone(String phone, CodeTypeEnum codeTypeEnum) {
        AssertUtil.isTrue(RegexUtil.checkPhone(phone), ExceptionEnum.IncorrectPhone);
        switch (codeTypeEnum) {
            case ChangePassword:
                UserBo userBo = userService.getUserByPhone(phone);
                AssertUtil.notNull(userBo, ExceptionEnum.NotExistsPhone);
                break;
            default:
                break;
        }
    }

    public void validCode(String code, String phone, CodeTypeEnum codeTypeEnum) {
        String key = SmsUtil.generateSmsKey(codeTypeEnum.name(), phone);
        AssertUtil.hasLength(code, ExceptionEnum.NotNullCode);
        boolean codeValidFlag = redisUtil.valueCheck(key, code);
        AssertUtil.isTrue(codeValidFlag, ExceptionEnum.IncorrectCode);
    }
}
