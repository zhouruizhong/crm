package com.zrz.crm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author qcdl
 * @date 2019/6/19
 */
@Getter
@AllArgsConstructor
public enum DeleteFlagEnum {

    /**
     * 已删除
     */
    DELETED(0),

    /**
     * 未删除
     */
    NOT_DELETED(1);

    private Integer code;
}
