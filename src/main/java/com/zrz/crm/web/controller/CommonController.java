package com.zrz.crm.web.controller;

import com.zrz.crm.web.config.advice.ExceptionEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author zrz
 * @desc 公共
 * @date 2019/10/14
 */
@RestController
@RequestMapping(value = "common", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "公共", tags = {"公共"}, hidden = true, produces = MediaType.APPLICATION_JSON_VALUE)
public class CommonController {

    /**
     * 未授权跳转方法
     * @return
     */
    @ApiOperation(value = "未授权", notes = "未授权", hidden = true)
    @RequestMapping("/unauth")
    public String unauth(){
        return ExceptionEnum.NotPermission.getMsg();
    }

    /**
     * 被踢出后跳转方法
     * @return
     */
    @ApiOperation(value = "踢出", notes = "踢出", hidden = true)
    @RequestMapping("/kickout")
    public String kickout(){
        return "INVALID_TOKEN";
    }
}
