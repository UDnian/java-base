package com.wdx.thread.wdx.test3;

/**
 * @author wangdongxing
 * @since 2019-03-20 08:16
 */
public class ThreadMain {

    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        Thread thread = new Thread(myThread3);
        thread.setName("A");
        thread.start();
    }

}
