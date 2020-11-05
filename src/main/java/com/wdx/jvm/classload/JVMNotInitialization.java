package com.wdx.jvm.classload;

/**
 * @author wangdongxing
 * @since 2019-07-05 16:23
 */
public class JVMNotInitialization {

    public static void main(String[] args) {
        // System.out.println(JVMSubClass.value);
        // JVMSubClass[] array = new JVMSubClass[10];
        System.out.println(JVMSubClass.HELLOWORLD);
    }

}
