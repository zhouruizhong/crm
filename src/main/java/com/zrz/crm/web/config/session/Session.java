package com.zrz.crm.web.config.session;

import com.zrz.crm.utils.CodecUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户TOKEN
 *
 * @author qcdl
 * @date 2019/6/6
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Session implements Serializable {
    private String token;
    private Object user;

    public static String generateToken(String id, Date loginTime) {
        return CodecUtil.getMD5Cryptography(id + (loginTime == null ? 0L : loginTime.getTime()));
    }

}
