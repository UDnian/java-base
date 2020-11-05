package com.wdx.thread.wdx.test2;

/**
 * @author wangdongxing
 * @since 2019-02-26 12:34
 */
public class Test {

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.setName("myThread");
            myThread.start();
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
