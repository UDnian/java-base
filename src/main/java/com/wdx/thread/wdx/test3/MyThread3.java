package com.wdx.thread.wdx.test3;

/**
 * @author wangdongxing
 * @since 2019-03-20 08:13
 */
public class MyThread3 extends Thread {

    public MyThread3() {
        System.out.println("MyThread3 = " + Thread.currentThread().getName());
        System.out.println("this.getName = " + this.getName());
    }

    @Override
    public void run() {
        System.out.println("run = " + Thread.currentThread().getName());
        System.out.println("run this.getName = " + this.getName());
    }
}
