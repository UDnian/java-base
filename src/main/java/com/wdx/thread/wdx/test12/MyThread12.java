package com.wdx.thread.wdx.test12;

/**
 * @author wangdongxing
 * @since 2019-05-13 15:32
 */
public class MyThread12 extends Thread {

    @Override
    public void run() {
        try {
            int secondValue = (int) (Math.random() * 10000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
