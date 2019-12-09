package com.zrz.crm.mapper;

import com.zrz.crm.config.BaseMapper;
import com.zrz.crm.model.User;
import com.zrz.crm.service.bo.UserBo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    UserBo getUserByPhone(@Param("phone") String phone);
}
