package com.wdx.thread.wdx.test6;

/**
 * @author wangdongxing
 * @since 2019-03-21 08:32
 */
public class MyObject6 {

    synchronized public void myMethod() {
        try {
            System.out.println("begin thread name: " + Thread.currentThread().getName());
            Thread.sleep(3000L);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
