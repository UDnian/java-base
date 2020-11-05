package com.wdx.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author wangdongxing
 * @since 2019-12-30 11:21
 */
@RestController
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Resource
    private FilterRegistrationBean filterRegistrationBean;

    @RequestMapping("/wdx/test")
    @ResponseBody
    public String test(HttpServletRequest request) {
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        LOGGER.info("maxInactiveInterval: {}", maxInactiveInterval);
        Map initParameters = filterRegistrationBean.getInitParameters();
        LOGGER.info("filter initParameters: {}", initParameters);
        return "test";
    }

}
