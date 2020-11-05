package com.wdx.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义 过滤器
 *
 * @author wangdongxing
 * @since 2019-12-31 15:37
 */
public class Custom2Filter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Custom2Filter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        LOGGER.info("Custom2Filter过滤处理url: {}", request.getRequestURI());

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
