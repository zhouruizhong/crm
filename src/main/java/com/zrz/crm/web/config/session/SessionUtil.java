package com.zrz.crm.web.config.session;

import com.zrz.crm.config.RedisUtil;
import com.zrz.crm.config.SpringContextUtil;
import com.zrz.crm.utils.JsonUtil;
import com.zrz.crm.web.config.advice.ExceptionEnum;
import com.zrz.crm.web.config.advice.WebException;
import com.zrz.crm.web.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户TOKEN生成
 *
 * @author qcdl
 * @date 2019/6/6
 */
public class SessionUtil {

    private static final String ACCESS_TOKEN = "ACCESS_TOKEN";
    private static final String ACCESS_TOKEN_KEY = "ACCESS_TOKEN_KEY";

    public static void save(String token, Object user) {
        Session s = new Session(token, user);
        SpringContextUtil.getBean(RedisUtil.class).save(ACCESS_TOKEN_KEY, token, s);
    }

    public static void update(String token, Object user) {
        save(token, user);
    }

    private static Session getSession(String token) {
        String session = SpringContextUtil.getBean(RedisUtil.class).get(ACCESS_TOKEN_KEY, token);
        if (StringUtils.isBlank(session)) {
            throw new WebException(ExceptionEnum.InValidToken);
        }
        return JsonUtil.getInstance().toJsonObj(session, Session.class);
    }

    public static void delete(HttpServletRequest request) {
        delete(getToken(request));
    }

    public static void delete(String token) {
        SpringContextUtil.getBean(RedisUtil.class).clear(ACCESS_TOKEN, token);
    }

    public static <T> T getUser(HttpServletRequest request, Class<T> clazz) {
        return getUser(getToken(request), clazz);
    }

    private static <T> T getUser(String token, Class<T> clazz) {
        Session s = getSession(token);
        return JsonUtil.getInstance().toJsonObj(JsonUtil.getInstance().toJsonString(s.getUser()), clazz);
    }

    public static void checkSession(HttpServletRequest request) {
        boolean isExist = SpringContextUtil.getBean(RedisUtil.class).hasKey(ACCESS_TOKEN_KEY, getToken(request));
        if (!isExist) {
            throw new WebException(ExceptionEnum.InValidToken);
        }
    }

    public static String getToken(HttpServletRequest request) {
        String oauthToken = CookieUtil.getUid(request, SessionConstant.OAUTH_KEY);
        if (StringUtils.isNotBlank(oauthToken)) {
            return oauthToken;
        }
        return request.getParameter(ACCESS_TOKEN);
    }
}
