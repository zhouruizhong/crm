package com.zrz.crm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AttrStatusEnum {

    /**
     * 新增
     */
    NEW("新增"),
    /**
     * 生效
     */
    VALID("生效"),
    /**
     * 失效
     */
    INVALID("失效");

    private String description;

    public static String NEW_VALUE = NEW.name();
    public static String VALID_VALUE = VALID.name();
    public static String INVALID_VALUE = INVALID.name();

    public static String getDescription(String value) {
        for (AttrStatusEnum v : AttrStatusEnum.values()) {
            if (v.name().equals(value)) {
                return v.getDescription();
            }
        }
        return "";
    }

}
