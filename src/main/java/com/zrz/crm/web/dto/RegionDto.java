package com.zrz.crm.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 描述信息
 *
 * @author okayic
 * @date 2019/10/26
 */
@Data
@ApiModel(value = "省市区域信息")
@AllArgsConstructor
@RequiredArgsConstructor
public class RegionDto implements Serializable {

    @ApiModelProperty("区域编码")
    @NonNull
    private String code;

    @ApiModelProperty("区域名称")
    @NonNull
    private String name;

    @ApiModelProperty("下级区域名称")
    private List<RegionDto> regionList;

}
