package com.wdx.web.interceptor.impl;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;

/**
 * UserId参数解析
 *
 * @author wangdongxing
 * @since 2020-01-05 23:11
 */
public class UserIdArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        // 参数上是否有@UserId注解
        return methodParameter.hasParameterAnnotation(UserId.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        Annotation[] annotations = methodParameter.getParameterAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof UserId) {
                // HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
                // String userId1 = request.getParameter("userId");
                String userId = nativeWebRequest.getParameter("userId");
                if (userId != null && !"".equals(userId)) {
                    return Long.parseLong(userId);
                }
            }
        }
        return null;
    }
}
