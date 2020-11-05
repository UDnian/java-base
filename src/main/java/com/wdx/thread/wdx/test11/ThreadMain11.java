package com.wdx.thread.wdx.test11;

/**
 * @author wangdongxing
 * @since 2019-04-02 08:34
 */
public class ThreadMain11 {
    public static void main(String[] args) {
        try {
            Object object = new Object();
            MyThreadA11 myThreadA11 = new MyThreadA11(object);
            myThreadA11.start();
            Thread.sleep(3000L);

            MyThreadB11 myThreadB11 = new MyThreadB11(object);
            myThreadB11.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
