package com.wdx.thread.wdx.test6;

/**
 * @author wangdongxing
 * @since 2019-03-21 08:35
 */
public class MyThreadA6 extends Thread {

    private MyObject6 myObject6;

    public MyThreadA6(MyObject6 myObject6) {
        this.myObject6 = myObject6;
    }

    @Override
    public void run() {
        myObject6.myMethod();
    }
}
