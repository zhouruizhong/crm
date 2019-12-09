package com.zrz.crm.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zrz
 * @desc 公告
 * @date 2019/9/27
 */

@Data
@ApiModel("公告参数")
public class NoticeParam implements Serializable {

    @ApiModelProperty("公告标题")
    private String title;
    @ApiModelProperty("公告内容")
    private String content;
}
