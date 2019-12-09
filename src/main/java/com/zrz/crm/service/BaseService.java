package com.zrz.crm.service;

import com.google.common.collect.Lists;
import com.zrz.crm.config.RedisUtil;
import com.zrz.crm.enums.CodeTypeEnum;
import com.zrz.crm.mapper.SysRegionMapper;
import com.zrz.crm.model.SysRegion;
import com.zrz.crm.utils.QiniuUtil;
import com.zrz.crm.utils.SmsUtil;
import com.zrz.crm.web.dto.QiniuDto;
import com.zrz.crm.web.dto.RegionDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author zrz
 * @desc 描述信息
 * @date 2019/9/28
 */
@Service
@Slf4j
public class BaseService {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private ValidService validService;

    @Resource
    private SysRegionMapper sysRegionMapper;

    public List<RegionDto> getRegionInfo() {
        List<SysRegion> sysRegionList = sysRegionMapper.selectAll();
        return getRegionInfo(null, sysRegionList);
    }

    private List<RegionDto> getRegionInfo(String parentCode, List<SysRegion> sysRegionList) {
        List<RegionDto> regionList = Lists.newArrayList();
        sysRegionList.stream().filter(obj -> Objects.equals(parentCode, obj.getParentCode())).forEach(obj -> {
            RegionDto regionDto = new RegionDto(obj.getCode(), obj.getName());
            regionDto.setRegionList(getRegionInfo(obj.getCode(), sysRegionList));
            regionList.add(regionDto);
        });
        return regionList;
    }

    /**
     * 短信验证码
     *
     * @param phone    手机号
     * @param codeType 验证码类型
     */
    public void sendSms(String phone, CodeTypeEnum codeType) {
        validService.validPhone(phone, codeType);
        String code = "123456";

        if (SmsUtil.isProdMode()) {
            code = RandomStringUtils.randomNumeric(6);
            SmsUtil.sendSms(phone, code, codeType);
        }

        redisUtil.valueSaveEx(SmsUtil.generateSmsKey(codeType.name(), phone), code, 5 * 60);

        log.info("短信发送(" + codeType.name() + ")" + phone + "\t 验证码 " + code);
    }

    /**
     * 七牛云配置信息
     *
     * @return 七牛云配置信息
     */
    public QiniuDto qiniuToken() {
        return new QiniuDto(QiniuUtil.getUrl(), QiniuUtil.generatePicToken());
    }

}
