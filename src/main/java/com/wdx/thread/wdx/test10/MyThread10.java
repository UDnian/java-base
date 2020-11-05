package com.wdx.thread.wdx.test10;

/**
 * @author wangdongxing
 * @since 2019-04-02 08:30
 */
public class MyThread10 implements Runnable {

    private volatile boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    @Override
    public void run() {
        printStringMethod();
    }

    private void printStringMethod() {

        try {
            while (isContinuePrint) {
                System.out.println("thread name : " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
