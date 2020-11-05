package com.wdx.thread.wdx.test11;

/**
 * @author wangdongxing
 * @since 2019-04-02 08:30
 */
public class MyThreadA11 extends Thread {
    private Object object;

    public MyThreadA11(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        try {
            synchronized (object) {
                System.out.println("开始 wait time = " + System.currentTimeMillis());
                object.wait();
                System.out.println("结束 wait time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
