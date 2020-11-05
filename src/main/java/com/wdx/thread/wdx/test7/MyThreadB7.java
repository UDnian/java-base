package com.wdx.thread.wdx.test7;

/**
 * @author wangdongxing
 * @since 2019-03-21 08:35
 */
public class MyThreadB7 extends Thread {

    private MyObject7 myObject7;

    public MyThreadB7(MyObject7 myObject7) {
        this.myObject7 = myObject7;
    }

    @Override
    public void run() {
        myObject7.myMethodB();
    }
}
