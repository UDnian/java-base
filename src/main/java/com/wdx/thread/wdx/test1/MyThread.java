package com.wdx.thread.wdx.test1;

/**
 * @author wangdongxing
 * @since 2019-02-26 12:17
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }
}
