package com.zrz.crm.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zrz
 * @desc 横幅
 * @date 2019/10/8
 */
@Data
@ApiModel(value = "横幅列表实体类")
public class BannerDto {

    @ApiModelProperty(value = "横幅id")
    private Integer id;

    @ApiModelProperty("名称")
    private String bannerName;

    @ApiModelProperty("图片URL")
    private String imgUrl;

    @ApiModelProperty("数据类型(0:商品 1:商户 2:外链)")
    private Integer dataType;

    @ApiModelProperty("数据值")
    private String dataValue;

    @ApiModelProperty("排序顺序")
    private Integer plainSeq;

    @ApiModelProperty("创建时间")
    private String createTime;
}
