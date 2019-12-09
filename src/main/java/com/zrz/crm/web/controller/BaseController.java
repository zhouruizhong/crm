package com.zrz.crm.web.controller;

import com.zrz.crm.enums.CodeTypeEnum;
import com.zrz.crm.service.BaseService;
import com.zrz.crm.utils.AssertUtil;
import com.zrz.crm.utils.RegexUtil;
import com.zrz.crm.web.config.advice.ExceptionEnum;
import com.zrz.crm.web.dto.QiniuDto;
import com.zrz.crm.web.dto.RegionDto;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zrz
 * @desc 公共基础接口
 * @date 2019/9/28
 */
@Api(value = "第三方API调用接口", tags = {"公共基础"}, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(value = "/base", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class BaseController {

    @Resource
    private BaseService baseService;

    @ApiOperation(value = "七牛云配置信息", notes = "七牛云文件上传token")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "接口调用凭证", defaultValue = "5c0ecfd7-2fc7-4c39-8271-d3ca520671ef", dataType = "string", required = true, paramType = "query")})
    @GetMapping(value = "/qiniu")
    public QiniuDto qiniuToken() {
        return baseService.qiniuToken();
    }

    @ApiOperation(value = "短信验证码", notes = "获取短信验证码")
    @GetMapping(value = "/sms")
    public void sendSmsCode(@ApiParam(value = "验证码类型(4:更改密码)", required = true) @RequestParam(value = "type") Integer type,
                            @ApiParam(value = "手机号", required = true) @RequestParam(value = "phone") String phone) {
        AssertUtil.isTrue(RegexUtil.checkPhone(phone), ExceptionEnum.IncorrectPhone);
        CodeTypeEnum codeType = CodeTypeEnum.parse(type);
        baseService.sendSms(phone, codeType);
    }

    @ApiOperation(value = "获取省市区域信息", notes = "获取省市区域信息")
    @GetMapping(value = "/region")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "接口调用凭证", defaultValue = "5c0ecfd7-2fc7-4c39-8271-d3ca520671ef", dataType = "string", required = true, paramType = "query")})
    public List<RegionDto> getRegionInfo() {
        return baseService.getRegionInfo();
    }
}
