package com.wdx.web.interceptor;

import com.wdx.web.interceptor.impl.DateConverter;
import com.wdx.web.interceptor.impl.MyWebRequestInterceptor;
import com.wdx.web.interceptor.impl.RequestInterceptor;
import com.wdx.web.interceptor.impl.ResponseExceptionHandler;
import com.wdx.web.interceptor.impl.UserArgumentResolver;
import com.wdx.web.interceptor.impl.UserFormatter;
import com.wdx.web.interceptor.impl.UserIdArgumentResolver;
import com.wdx.web.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * 拦截器配置
 *
 * @author wangdongxing
 * @since 2020-01-03 16:37
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    /**
     * 根据需求定制URL路径的匹配规则（不常用）
     *
     * @param configurer
     * @since 4.0.3
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
    }

    /**
     * 内容裁决解析器（不常用）
     *
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    }

    /**
     * 处理异步请求的（不常用）
     * <p>
     * Configure asynchronous request handling options.
     *
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

    }

    /**
     * 默认静态资源处理器
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    }

    @Resource
    private UserService userService;

    /**
     * 类型转换配置（userId可以转换为user对象）
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new UserFormatter(userService));
        registry.addConverter(new DateConverter());
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor();
    }

    @Bean
    public MyWebRequestInterceptor myWebRequestInterceptor() {
        return new MyWebRequestInterceptor();
    }

    /**
     * 自定义写拦截器，并指定拦截路径（常用）
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor()).addPathPatterns("/**");
        registry.addWebRequestInterceptor(myWebRequestInterceptor()).addPathPatterns("/**");
    }

    /**
     * 静态资源处理
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/index.html").addResourceLocations("classpath:/templates/index.html");
    }

    /**
     * 允许跨域请求设置
     *
     * @param registry
     * @since 4.2
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowCredentials(true);
    }

    /**
     * 自定义视图控制器（一个路径自动跳转到一个页面）
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    /**
     * 配置视图解析器
     *
     * @param registry
     * @since 4.1
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
    }

    /**
     * 参数解析器（把request中获取到的参数封装到controller的方法参数中）
     *
     * @param resolvers initially an empty list
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserIdArgumentResolver());
        resolvers.add(new UserArgumentResolver());
    }

    /**
     * 类似注解@ResponseBody功能，对controller的返回对象作统一的封装
     *
     * @param handlers initially an empty list
     */
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
    }

    /**
     * 定制HTTP消息转换器（不常用）
     * Spring Boot底层通过HttpMessageConverters依靠Jackson库将Java实体类输出为JSON格式。
     *
     * @param converters initially an empty list of converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    /**
     * 定制HTTP消息转换器（不常用），如：自定义转换器messageConverters返回XML格式数据
     *
     * @param converters the list of configured converters to extend.
     * @since 4.1.3
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    /**
     * controller统一异常处理
     *
     * @param resolvers initially an empty list
     * @see #extendHandlerExceptionResolvers(List)
     * @see WebMvcConfigurationSupport#addDefaultHandlerExceptionResolvers(List)
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(new ResponseExceptionHandler());
    }

    /**
     * Extending or modify the list of exception resolvers configured by default.
     * This can be useful for inserting a custom exception resolver without
     * interfering with default ones.
     *
     * @param resolvers the list of configured resolvers to extend
     * @see WebMvcConfigurationSupport#addDefaultHandlerExceptionResolvers(List)
     * @since 4.3
     */
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
    }

    /**
     * 数据校验（不常用）
     */
    @Override
    public Validator getValidator() {
        return null;
    }

    /**
     * Provide a custom {@link MessageCodesResolver} for building message codes
     * from data binding and validation error codes. Leave the return value as
     * {@code null} to keep the default.
     */
    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
