package com.wdx.web.interceptor.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * 与HandlerInterceptor相比
 * 相同点:
 * 两个接口都可用于Contrller层请求拦截，接口中定义的方法作用也是一样的。
 * WebRequestInterceptor间接实现了HandlerInterceptor，只是他们之间使用WebRequestHandlerInterceptorAdapter适配器类联系。
 * <p>
 * 不同点：
 * 1.WebRequestInterceptor的入参WebRequest是包装了HttpServletRequest 和HttpServletResponse的，通过WebRequest获取Request中的信息更简便。
 * 2.WebRequestInterceptor的preHandle是没有返回值的，说明该方法中的逻辑并不影响后续的方法执行，所以这个接口实现就是为了获取Request中的信息，或者预设一些参数供后续流程使用。
 * 3.HandlerInterceptor的功能更强大也更基础，可以在preHandle方法中就直接拒绝请求进入controller方法。
 *
 * @author wangdongxing
 * @since 2020-01-05 00:08
 */
public class MyWebRequestInterceptor implements WebRequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyWebRequestInterceptor.class);

    /**
     * 与HandlerInterceptor.preHandle()方法相比没有返回值，意思
     *
     * @param webRequest
     * @return void
     * @author wangdongxing
     * @since 2020-01-05 00:10
     */
    @Override
    public void preHandle(WebRequest webRequest) throws Exception {
        LOGGER.info("MyWebRequestInterceptor preHandle");
    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {
        LOGGER.info("MyWebRequestInterceptor postHandle");
    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {
        LOGGER.info("MyWebRequestInterceptor afterCompletion");
    }
}
