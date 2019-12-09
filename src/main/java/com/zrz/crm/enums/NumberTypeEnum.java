package com.zrz.crm.enums;

import com.zrz.crm.web.config.advice.ExceptionEnum;
import com.zrz.crm.web.config.advice.WebException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author zrz
 * @desc 单号类型
 * @date 2019/10/8
 */

@AllArgsConstructor
@Getter
public enum NumberTypeEnum {

    /**
     * 故障
     */
    REPORT("1", "故障单"),
    AUDIT("2", "审核单"),
    REPAIR("3", "维修单"),
    FEEDBACK("4","反馈单"),
    MAINTAIN("5","维修计划");

    private String code;
    private String description;

    public static String REPORT_VALUE = REPORT.name();
    public static String AUDIT_VALUE = AUDIT.name();
    public static String REPAIR_VALUE = REPAIR.name();
    public static String FEEDBACK_VALUE = FEEDBACK.name();
    public static String MAINTAIN_VALUE = MAINTAIN.name();

    public static NumberTypeEnum parse(String code) {
        for (NumberTypeEnum levelEnum : NumberTypeEnum.values()) {
            if (Objects.equals(levelEnum.name(), code)) {
                return levelEnum;
            }
        }
        throw new WebException(ExceptionEnum.IncorrectType);
    }

    public static String getDescription(String value) {
        for (NumberTypeEnum v : NumberTypeEnum.values()) {
            if (v.name().equals(value)) {
                return v.getDescription();
            }
        }
        return "";
    }
}
