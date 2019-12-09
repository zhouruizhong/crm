package com.zrz.crm.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 七牛云配置信息
 *
 * @author qcdl
 * @date 2019/6/6
 */
@ApiModel(value = "七牛TOKEN")
@Data
@AllArgsConstructor
public class QiniuDto implements Serializable {

    @ApiModelProperty("上传URL根路径")
    private String url;

    @ApiModelProperty("TOKEN")
    private String token;
}
