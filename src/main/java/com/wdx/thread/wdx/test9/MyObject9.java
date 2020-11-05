package com.wdx.thread.wdx.test9;

/**
 * @author wangdongxing
 * @since 2019-03-22 17:12
 */
public class MyObject9 {
    public void print(String s) {
        try {
            synchronized (s) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
