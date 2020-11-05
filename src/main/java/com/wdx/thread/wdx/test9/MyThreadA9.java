package com.wdx.thread.wdx.test9;

/**
 * @author wangdongxing
 * @since 2019-03-21 08:35
 */
public class MyThreadA9 extends Thread {

    private MyObject9 myObject9;

    public MyThreadA9(MyObject9 myObject9) {
        this.myObject9 = myObject9;
    }

    @Override
    public void run() {
        myObject9.print("SSS");
    }
}
