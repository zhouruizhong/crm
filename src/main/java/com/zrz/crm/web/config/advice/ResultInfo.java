package com.zrz.crm.web.config.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一返回值封装
 *
 * @author qcdl
 * @date 2019/6/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class ResultInfo<T> implements Serializable {
    private Integer code;
    private T data;
    private String msg;
}
