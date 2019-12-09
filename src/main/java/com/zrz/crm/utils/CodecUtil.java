package com.zrz.crm.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import java.util.Arrays;

/**
 * 加解密工具
 *
 * @author qcdl
 * @date 2019/6/6
 */
public final class CodecUtil {

    public static String getMD5Cryptography(String expression) {
        return DigestUtils.md5Hex(expression);
    }

    public static String getMD5CryptographyHexBit(String expression) {
        return getMD5Cryptography(expression).substring(8, 24);
    }

    public static String generateEncryptPassword(String password, String salt, boolean isPlainPassword) {
        if (isPlainPassword) {
            password = getMD5Cryptography(password);
        }
        return getMD5Cryptography(password.concat(salt));
    }

    public static String encryptSHA1(String expression) {
        return Arrays.toString(DigestUtils.sha1(expression));
    }

    public static String encryptSHA1Hex(String expression) {
        return DigestUtils.sha1Hex(expression);
    }

}
