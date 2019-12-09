package com.zrz.crm.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zrz
 * @desc 用户信息
 * @date 2019/10/14
 */
@Data
@ApiModel("用户信息")
public class UserVo {
    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("职位编号")
    private String positionCode;

    @ApiModelProperty("职位名称")
    private String positionName;

    @ApiModelProperty("部门编号")
    private String deptCode;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("单位id")
    private Integer orgId;

    @ApiModelProperty("单位名称")
    private String orgName;

    @ApiModelProperty("角色编号")
    private String roleCode;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("编号")
    private String code;

    @ApiModelProperty("手机号码")
    private String mobile;

    @ApiModelProperty("邮箱")
    private String email;

    public String getSex(){
        return "male".equalsIgnoreCase(sex) ? "男" : "女";
    }
}
