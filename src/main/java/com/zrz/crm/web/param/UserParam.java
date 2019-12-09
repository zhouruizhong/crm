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
@ApiModel("用户信息")
public class UserParam implements Serializable {

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Integer userId;
    /**
     * 名称
     */
    @ApiModelProperty("姓名")
    private String name;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;
    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String portrait;
}
