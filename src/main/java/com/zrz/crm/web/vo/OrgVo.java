package com.zrz.crm.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author zrz
 */

@Data
@ApiModel
public class OrgVo {

    @ApiModelProperty("单位id")
    private Integer orgId;
    @ApiModelProperty("单位名称")
    private String orgName;
}
