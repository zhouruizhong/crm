package com.zrz.crm.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zrz
 * @desc 统计
 * @date 2019/10/8
 */
@Data
@ApiModel("设备维修统计")
public class StatisticDeviceDto implements Serializable {

    @ApiModelProperty("设备ID")
    private Integer orgId;
    @ApiModelProperty("设备名称")
    private String orgName;
    @ApiModelProperty("维修量")
    private Integer count;
}
