package com.wdx.thread.wdx.test7;

/**
 * @author wangdongxing
 * @since 2019-03-21 08:32
 */
public class MyObject7 {

    synchronized public void myMethodA() {
        try {
            System.out.println("A begin thread name: " + Thread.currentThread().getName());
            Thread.sleep(3000L);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void myMethodB() {
        try {
            System.out.println("B begin thread name: " + Thread.currentThread().getName());
            Thread.sleep(3000L);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
