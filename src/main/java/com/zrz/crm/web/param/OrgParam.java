package com.zrz.crm.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zrz
 * @desc 描述信息
 * @date 2019/9/27
 */

@Data
@ApiModel("单位信息")
public class OrgParam {
    /**
     * 机构id
     */
    @ApiModelProperty("单位ID")
    private Integer id;
    /**
     * 机构名称
     */
    @ApiModelProperty("单位名称")
    private String name;
}
