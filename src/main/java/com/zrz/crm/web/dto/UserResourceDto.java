package com.zrz.crm.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zrz
 * @desc 描述信息
 * @date 2019/9/28
 */
@Data
@ApiModel("")
public class UserResourceDto {
    @ApiModelProperty("")
    private Integer userId;
    @ApiModelProperty("")
    private String name;
    @ApiModelProperty("")
    private String mobile;
    @ApiModelProperty("")
    private String token;
    @ApiModelProperty("")
    private String resource;
}
