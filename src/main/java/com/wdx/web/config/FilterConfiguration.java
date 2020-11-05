package com.wdx.web.config;

import com.wdx.web.filter.Custom2Filter;
import com.wdx.web.filter.CustomFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 过滤器配置
 *
 * @author wangdongxing
 * @since 2019-12-31 16:31
 */
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(customFilter());
        filterRegistrationBean.addUrlPatterns("/wdx/*");
        filterRegistrationBean.addInitParameter("name", "CustomFilter");
        filterRegistrationBean.setName("customFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(custom2Filter());
        filterRegistrationBean.addUrlPatterns("/wdx/*");
        filterRegistrationBean.addInitParameter("name", "CustomFilter2");
        filterRegistrationBean.setName("customFilter2");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

    @Bean
    public Filter customFilter() {
        return new CustomFilter();
    }

    @Bean
    public Filter custom2Filter() {
        return new Custom2Filter();
    }

}
