package com.zrz.crm.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qcdl
 * @date 2019/8/9
 */
@Data
@ApiModel("推送通知配置信息")
public class PushConfigDto implements Serializable {

    @ApiModelProperty("端点")
    private String endpoint;

    @ApiModelProperty("订阅地址")
    private String subscribeUrl;

}
