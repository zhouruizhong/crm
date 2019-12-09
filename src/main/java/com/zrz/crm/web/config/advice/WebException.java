package com.zrz.crm.web.config.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 统一异常处理
 *
 * @author qcdl
 * @date 2019/6/5
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class WebException extends RuntimeException {
    private Integer code;
    private String msg;

    public WebException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }
}
