package com.zrz.crm.enums;

import com.zrz.crm.web.config.advice.ExceptionEnum;
import com.zrz.crm.web.config.advice.WebException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;


/**
 * 短信相关操作
 *
 * @author qcdl
 * @date 2019/6/6
 */
@Getter
@AllArgsConstructor
public enum CodeTypeEnum {

    /**
     * 修改密码
     */
    ChangePassword(4);

    private Integer code;

    public static CodeTypeEnum parse(Integer code) {
        for (CodeTypeEnum codeType : CodeTypeEnum.values()) {
            if (Objects.equals(codeType.code, code)) {
                return codeType;
            }
        }
        throw new WebException(ExceptionEnum.IncorrectType);
    }

}

