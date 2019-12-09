package com.zrz.crm.web.config.annotation;

import com.zrz.crm.web.config.enums.RealVerifyEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 接口鉴权注解
 *
 * @author qcdl
 * @date 2019/6/6
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RealVerify {

    /**
     * 实名检查注解
     *
     * @return default CHECK
     */
    RealVerifyEnum value() default RealVerifyEnum.CHECK;
}
