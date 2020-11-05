package com.wdx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解 小姐姐
 *
 * @author wangdongxing
 * @since 2019-09-09 17:10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Girl {

    String name() default "good girl";

    String cup() default "";
}
