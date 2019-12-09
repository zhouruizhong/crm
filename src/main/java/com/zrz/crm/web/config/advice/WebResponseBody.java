package com.zrz.crm.web.config.advice;

import com.zrz.crm.utils.JsonUtil;
import com.zrz.crm.web.config.SwaggerConfig;
import com.zrz.crm.web.config.annotation.ResponseAdvice;
import com.zrz.crm.web.config.enums.ResponseAdviceEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 统一响应、异常配置
 *
 * @author qcdl
 * @date 2019/6/5
 */
@RestControllerAdvice
@Slf4j
public class WebResponseBody implements ResponseBodyAdvice<Object> {

    @ExceptionHandler(value = Exception.class)
    public ResultInfo<String> handle(HttpServletRequest request, Exception e) {
        ResultInfo<String> resultInfo = new ResultInfo<>(ExceptionEnum.Exception.getCode(), null, ExceptionEnum.Exception.getMsg());
        if (e instanceof WebException) {
            WebException webException = (WebException) e;
            resultInfo.setCode(webException.getCode());
            resultInfo.setMsg(webException.getMsg());
        }
        e.printStackTrace();
        return resultInfo;
    }

    @Override
    public boolean supports(@Nonnull MethodParameter returnType, @Nonnull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, @Nonnull MethodParameter returnType, @Nonnull MediaType selectedContentType,
                                  @Nonnull Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, @Nonnull ServerHttpResponse response) {
        String uri = request.getURI().toString();
        if (StringUtils.containsIgnoreCase(uri, SwaggerConfig.SWAGGER_NAME_SYMBOL) ||
                StringUtils.containsIgnoreCase(uri, SwaggerConfig.SWAGGER_API_DOCS_SYMBOL)) {
            return body;
        }

        Method method = returnType.getMethod();
        if (method != null && method.getAnnotation(ResponseAdvice.class) != null) {
            ResponseAdviceEnum responseAdviceEnum = method.getAnnotation(ResponseAdvice.class).value();
            if (responseAdviceEnum == ResponseAdviceEnum.NOT_REQUIRED) {
                return body;
            }
        }

        if (body instanceof ResultInfo) {
            return body;
        }

        ResultInfo result = new ResultInfo<>(ExceptionEnum.Success.getCode(), body, ExceptionEnum.Success.getMsg());

        if (body instanceof String) {
            return JsonUtil.getInstance().toJsonString(result);
        }

        return result;
    }
}
