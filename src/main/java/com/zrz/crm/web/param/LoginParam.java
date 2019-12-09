package com.zrz.crm.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zrz
 * @desc 登录信息
 * @date 2019/9/28
 */
@Data
@ApiModel("登录参数")
public class LoginParam implements Serializable {

    @ApiModelProperty(value = "用户名、手机号、邮箱", required = true, example = "13128746930")
    private String phone;

    @ApiModelProperty(value = "密码(MD5加密)", required = true, example = "e10adc3949ba59abbe56e057f20f883e")
    private String password;
}
