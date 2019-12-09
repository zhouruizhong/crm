package com.zrz.crm.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zrz
 * @desc 描述信息
 * @date 2019/9/28
 */
@Data
@ApiModel("重置密码")
public class UserResetParam implements Serializable {

    @ApiModelProperty(value = "手机号", example = "13871434586")
    private String phone;

    @ApiModelProperty(value = "验证码", example = "123456")
    private String code;

    @ApiModelProperty(value = "密码 MD5加密", example = "e10adc3949ba59abbe56e057f20f883e")
    private String password;
}
