package com.wdx.thread.wdx.test13;

/**
 * @author wangdongxing
 * @since 2019-05-13 16:05
 */
public class ThreadMain13 {
    public static void main(String[] args) {
        MyThreadA13 myThreadA13 = new MyThreadA13();
        MyThreadB13 myThreadB13 = new MyThreadB13();
        myThreadA13.start();
        myThreadB13.start();

        try {
            for (int i = 0; i < 5; i++) {
                Tools.threadLocal.set("Main" + (i + 1));
                System.out.println("Main get Value = " + Tools.threadLocal.get());
                Thread.sleep(200L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
