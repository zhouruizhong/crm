package com.zrz.crm.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zrz
 * @desc 维修单位
 * @date 2019/10/8
 */
@Data
@ApiModel("维修单位")
public class OrgDto implements Serializable {

    @ApiModelProperty("单位id")
    private Integer orgId;
    @ApiModelProperty("单位名称")
    private String orgName;
    @ApiModelProperty("待审核")
    private int pend;
    @ApiModelProperty("待维修")
    private int wait;
    @ApiModelProperty("维修中")
    private int doing;
    @ApiModelProperty("问题忽略")
    private int ignore;
    @ApiModelProperty("反馈")
    private int feedback;
    @ApiModelProperty("优秀")
    private int excellent;
    @ApiModelProperty("优良")
    private int good;
    @ApiModelProperty("合格")
    private int qualified;
}
