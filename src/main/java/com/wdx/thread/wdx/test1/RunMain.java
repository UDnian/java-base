package com.wdx.thread.wdx.test1;

/**
 * @author wangdongxing
 * @since 2019-02-26 12:20
 */
public class RunMain {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("运行结束");
    }

}
