package com.zrz.crm.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局Web配置
 *
 * @author qcdl
 * @date 2019/6/5
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Bean
  public WebInterceptor webInterceptor() {
    return new WebInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(webInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/static/**")
        .excludePathPatterns("/webjars/**", "/api-docs/**", "/swagger-resources/**");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
  }
}
