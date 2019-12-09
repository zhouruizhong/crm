package com.zrz.crm.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 *
 * @author zrz
 * @date 2019/6/5
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
