package com.zrz.crm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 描述信息
 *
 * @author qcdl
 * @date 2019/10/26
 */
@AllArgsConstructor
@Getter
public enum RegionTypeEnum {

    /**
     * 省
     */
    Province(0),

    /**
     * 市
     */
    City(1),

    /**
     * 区
     */
    Area(2);

    private Integer code;

}
