package com.wdx.thread.wdx.test13;

/**
 * @author wangdongxing
 * @since 2019-05-13 16:04
 */
public class MyThreadB13 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Tools.threadLocal.set("MyThreadB" + (i + 1));
                System.out.println("MyThreadB get Value = " + Tools.threadLocal.get());
                Thread.sleep(200L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
