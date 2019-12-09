package com.zrz.crm.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author rickliu
 */
@Data
@ApiModel("用户信息更新参数")
public class UserUpdateParam implements Serializable {

    @ApiModelProperty(value = "用户头像")
    private String portrait;

    @ApiModelProperty(value = "用户名称")
    private String name;

    @ApiModelProperty(value = "用户性别(0:未知  1:男  2:女)")
    private Integer sex;

    @ApiModelProperty(value = "邮箱")
    private String email;

}
