package com.zrz.crm.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zrz
 * @desc 用户信息
 * @date 2019/9/28
 */
@Data
@ApiModel("用户登录返回信息")
public class UserDto implements Serializable {

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("用户名称")
    private String name;

    @ApiModelProperty("账号类型(0:干线公司 1:管理局 2:管理处 3:维修公司 4:维修人员)")
    private Integer type;

    @ApiModelProperty("用户性别(0:未知  1:男  2:女)")
    private Integer sex;

    @ApiModelProperty("单位名称")
    private String unitName;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("职位名称")
    private String positionName;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("头像")
    private String portrait;

}
