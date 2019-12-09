package com.zrz.crm.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zrz
 * @desc 统计
 * @date 2019/10/8
 */
@Data
public class StatisticDto implements Serializable {

    @ApiModelProperty("单位ID")
    private Integer orgId;
    @ApiModelProperty("单位名称")
    private String orgName;
    @ApiModelProperty("排名")
    private Integer priority;
    @ApiModelProperty("维修量")
    private Integer count;
}
