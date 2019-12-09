package com.zrz.crm.web.config.annotation;


import com.zrz.crm.web.config.enums.ResponseAdviceEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 接口统一格式响应注解
 *
 * @author qcdl
 * @date 2019/6/6
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseAdvice {

    /**
     * 接口统一格式响应
     *
     * @return default REQUIRE
     */
    ResponseAdviceEnum value() default ResponseAdviceEnum.REQUIRED;
}
