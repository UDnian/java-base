package com.wdx.thread.wdx.test10;

/**
 * @author wangdongxing
 * @since 2019-04-02 08:34
 */
public class ThreadMain10 {
    public static void main(String[] args) {
        MyThread10 myThread10 = new MyThread10();
        new Thread(myThread10).start();
        System.out.println("我要停止它：thread name : " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread10.setContinuePrint(false);
    }
}
