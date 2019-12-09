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
@ApiModel("用户信息")
public class UserDetailDto {

    @ApiModelProperty("token")
    private String token;
    @ApiModelProperty("用户id")
    private Integer id;
    @ApiModelProperty("编号")
    private String code;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("密码")
    private String pwd;
    private String salt;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("所属部门id")
    private Integer deptId;
    @ApiModelProperty("所属部门名称")
    private String deptName;
    @ApiModelProperty("职位id")
    private Integer positionId;
    @ApiModelProperty("职位名称")
    private String positionName;
    @ApiModelProperty("所属单位id")
    private Integer orgId;
    @ApiModelProperty("所属单位名称")
    private String orgName;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("头像")
    private String portrait;

}
