package com.zrz.crm.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zrz
 * @desc 描述信息
 * @date 2019/10/8
 */

@Data
@ApiModel(value = "新增banner所需参数")
public class BannerParam {
    @ApiModelProperty("横幅名称")
    private String bannerName;

    @ApiModelProperty("横幅图片url")
    private String imgUrl;

    @ApiModelProperty("数据类型(0:商品 1:商户 2:外链)")
    private Integer dataType;

    @ApiModelProperty("数据值")
    private String dataValue;

    @ApiModelProperty("排序顺序")
    private Integer plainSeq;
}
