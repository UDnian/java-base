package com.wdx.jvm.classload;

/**
 * @author wangdongxing
 * @since 2019-07-05 16:21
 */
public class JVMSubClass extends JVMSuperClass {

    public static final String HELLOWORLD = "hello world";

    static {
        System.out.println("SubClass init!");
    }

}
