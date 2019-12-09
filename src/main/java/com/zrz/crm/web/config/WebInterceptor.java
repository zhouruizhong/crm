package com.zrz.crm.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局拦截器
 *
 * @author qcdl
 * @date 2019/6/5
 */
@Slf4j
public class WebInterceptor extends HandlerInterceptorAdapter {

    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false 则退出本拦截器，本拦截器后面的postHandle与afterCompletion不再执行
     *
     * @param request  request
     * @param response response
     * @param handler  handler
     * @return true/false
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws IOException {
        return true;
    }

    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     *
     * @param request      request
     * @param response     response
     * @param handler      handler
     * @param modelAndView modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) {

    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用
     * 当拦截器抛出异常时,依然会从当前拦截器往回执行所的拦截器的afterCompletion()
     *
     * @param request   request
     * @param response  response
     * @param handler   handler
     * @param exception e
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exception) {
    }
}
