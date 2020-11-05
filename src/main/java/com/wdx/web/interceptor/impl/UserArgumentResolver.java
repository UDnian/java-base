package com.wdx.web.interceptor.impl;

import com.wdx.web.model.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * User实体参数解析
 *
 * @author wangdongxing
 * @since 2020-01-05 23:11
 */
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        // 参数类型是否为User
        return methodParameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        String userId = nativeWebRequest.getParameter("userId");
        String name = nativeWebRequest.getParameter("name");
        if (userId != null && name != null) {
            return new User(Long.parseLong(userId), name, null, null);
        }
        return null;
    }
}
