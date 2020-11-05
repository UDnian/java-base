package com.wdx.web.interceptor.impl;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义一种数据，叫做userId
 * 注解是用于修饰参数的
 * 注解携带了个参数required，在这里，是个类似接口的声明；但是在后面，则要通过此信息决定解析器的行为。
 *
 * @author wangdongxing
 * @since 2020-01-05 23:07
 */
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserId {
    boolean required() default true;
}
