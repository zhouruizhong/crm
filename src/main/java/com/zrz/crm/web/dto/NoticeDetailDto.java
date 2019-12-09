package com.zrz.crm.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zrz
 * @desc 公告详情
 * @date 2019/9/29
 */
@ApiModel
@Data
public class NoticeDetailDto implements Serializable {

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("发布时间")
    private String createTime;

}
