package com.wdx.thread.wdx.test12;

/**
 * @author wangdongxing
 * @since 2019-05-13 15:34
 */
public class ThreadMain12 {

    public static void main(String[] args) {
        try {
            MyThread12 myThread12 = new MyThread12();
            myThread12.start();
            myThread12.join();
            System.out.println("我想当 MyThread12 对象执行完后我再执行，我做到了");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
