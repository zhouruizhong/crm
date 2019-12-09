package com.zrz.crm.web.config.aop;

import com.google.common.collect.Maps;
import com.zrz.crm.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * 前端传参打印
 *
 * @author zrz
 */
//@Aspect
//@Configuration
@Slf4j
public class LogAspect {

    /**
     * 定义切点Pointcut
     */
    @Pointcut("execution(* com.zrz.crm.web.controller..*.*(..))")
    public void executeService() {
    }

    @Around("executeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;

        assert sra != null;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        Object[] args = pjp.getArgs();
        String params = "";
        if (args.length > 0) {
            if ("POST".equals(method)) {
                Object object = args[0];
                Map<String, Object> map = getKeyAndValue(object);
                params = JsonUtil.getInstance().toJsonString(map);
            } else if ("GET".equals(method)) {
                params = queryString;
            }
        }

        log.info("请求开始===地址:{}", url);
        log.info("请求开始===类型:{}", method);
        log.info("请求开始===参数:{}", params);

        Object result = pjp.proceed();
        log.info("请求结束===返回值:{}", JsonUtil.getInstance().toJsonString(pjp.proceed()));

        return result;
    }

    public static Map<String, Object> getKeyAndValue(Object obj) {
        Map<String, Object> map = Maps.newHashMap();
        Class userCla = obj.getClass();
        Field[] fs = userCla.getDeclaredFields();
        for (Field f : fs) {
            f.setAccessible(true);
            try {
                Object val = f.get(obj);
                map.put(f.getName(), val);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return map;
    }
}
