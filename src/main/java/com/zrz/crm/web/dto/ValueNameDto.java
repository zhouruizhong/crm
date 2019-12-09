package com.zrz.crm.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("参数")
public class ValueNameDto {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("编号")
    private String code;
    @ApiModelProperty("名称")
    private String name;
}
