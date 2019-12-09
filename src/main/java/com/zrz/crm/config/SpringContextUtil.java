package com.zrz.crm.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

/**
 * IOC工具
 *
 * @author qcdl
 * @date 2019/6/7
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(@Nonnull ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.setContext(applicationContext);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return SpringContextUtil.getContext().getBean(requiredType);
    }

    private static ApplicationContext getContext() {
        return context;
    }

    private static void setContext(ApplicationContext context) {
        SpringContextUtil.context = context;
    }

    public static String getProperty(String key) {
        return context.getEnvironment().getProperty(key);
    }
}
