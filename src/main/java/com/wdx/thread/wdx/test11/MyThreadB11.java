package com.wdx.thread.wdx.test11;

/**
 * @author wangdongxing
 * @since 2019-04-02 08:30
 */
public class MyThreadB11 extends Thread {
    private Object object;

    public MyThreadB11(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            System.out.println("开始 notify time = " + System.currentTimeMillis());
            object.notify();
            System.out.println("结束 notify time = " + System.currentTimeMillis());
        }
    }
}
