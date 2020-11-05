package com.wdx.thread.wdx.test13;

/**
 * @author wangdongxing
 * @since 2019-05-13 16:00
 */
public class MyThreadA13 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Tools.threadLocal.set("MyThreadA" + (i + 1));
                System.out.println("MyThreadA get Value = " + Tools.threadLocal.get());
                Thread.sleep(200L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
