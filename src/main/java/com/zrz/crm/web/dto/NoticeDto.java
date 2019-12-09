package com.zrz.crm.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zrz
 * @desc 公告
 * @date 2019/9/27
 */
@Data
@ApiModel
public class NoticeDto implements Serializable {
    @ApiModelProperty("记录id")
    private Integer id;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("序号-预留")
    private String sort;
}
