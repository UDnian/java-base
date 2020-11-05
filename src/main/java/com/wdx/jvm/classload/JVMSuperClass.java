package com.wdx.jvm.classload;

/**
 * @author wangdongxing
 * @since 2019-07-05 16:20
 */
public class JVMSuperClass {

    public static int value = 123;

    static {
        System.out.println("SuperClass init!");
    }

}
