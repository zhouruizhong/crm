package com.zrz.crm.utils;

import com.zrz.crm.web.config.advice.ExceptionEnum;
import com.zrz.crm.web.config.advice.WebException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 常用判断工具
 *
 * @author qcdl
 * @date 2019/6/5
 */
public class AssertUtil {

    /**
     * 为真
     *
     * @param expression 判断条件
     * @param message    expression = false，抛出异常信息
     */
    public static void isTrue(boolean expression, Integer code, String message) {
        if (!expression) {
            throw new WebException(code, message);
        }
    }

    public static void isTrue(boolean expression, ExceptionEnum exceptionEnum) {
        isTrue(expression, exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    /**
     * 为假
     *
     * @param expression 判断条件
     * @param message    expression = true，抛出异常信息
     */
    public static void isFalse(boolean expression, Integer code, String message) {
        if (expression) {
            throw new WebException(code, message);
        }
    }

    public static void isFalse(boolean expression, ExceptionEnum exceptionEnum) {
        isFalse(expression, exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    /**
     * 为空
     *
     * @param object  判断对象
     * @param message 不为空抛出异常信息
     */
    public static void isNull(Object object, Integer code, String message) {
        if (object != null) {
            throw new WebException(code, message);
        }
    }

    /**
     * 为空
     *
     * @param object        判断对象
     * @param exceptionEnum 不为空抛出异常信息
     */
    public static void isNull(Object object, ExceptionEnum exceptionEnum) {
        isNull(object, exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    /**
     * 不为空
     *
     * @param object  判断对象
     * @param message 为空抛出异常信息
     */
    public static void notNull(Object object, Integer code, String message) {
        if (null == object) {
            throw new WebException(code, message);
        }
    }

    public static void notNull(Object object, ExceptionEnum exceptionEnum) {
        notNull(object, exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    /**
     * 不为空字符串
     *
     * @param text    字符串
     * @param message 为空字符串抛出异常
     */
    public static void hasLength(String text, Integer code, String message) {
        if (StringUtils.isBlank(text)) {
            throw new WebException(code, message);
        }
    }

    public static void hasLength(String text, ExceptionEnum exceptionEnum) {
        if (StringUtils.isBlank(text)) {
            throw new WebException(exceptionEnum.getCode(), exceptionEnum.getMsg());
        }
    }

    /**
     * 数组不为空
     *
     * @param array   数组
     * @param message 为空抛出异常
     */
    public static void notEmpty(Object[] array, Integer code, String message) {
        if (ObjectUtils.isEmpty(array)) {
            throw new WebException(code, message);
        }
    }

    /**
     * 没有空对象
     *
     * @param array   数组
     * @param message 包含空对象抛出异常
     */
    public static void noNullElements(Object[] array, Integer code, String message) {
        if (array != null) {
            for (Object element : array) {
                if (element == null) {
                    throw new WebException(code, message);
                }
            }
        }
    }

    /**
     * 不为空
     *
     * @param collection 集合
     * @param message    为空抛出异常
     */
    public static void notEmpty(Collection<?> collection, Integer code, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new WebException(code, message);
        }
    }

    public static void notEmpty(Collection<?> collection, ExceptionEnum exceptionEnum) {
        notEmpty(collection, exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    /**
     * map不为空
     *
     * @param map     hash表
     * @param message 为空抛出异常
     */
    public static void notEmpty(Map<?, ?> map, Integer code, String message) {
        if (CollectionUtils.isEmpty(map)) {
            throw new WebException(code, message);
        }
    }
}
