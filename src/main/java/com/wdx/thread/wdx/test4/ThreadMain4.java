package com.wdx.thread.wdx.test4;

/**
 * @author wangdongxing
 * @since 2019-03-20 08:56
 */
public class ThreadMain4 {

    public static void main(String[] args) {
        // Thread.currentThread().interrupt();
        // System.out.println("是否停止1：" + Thread.interrupted());
        // System.out.println("是否停止2：" + Thread.interrupted());
        // Thread.currentThread().interrupt();
        // System.out.println("是否停止3：" + Thread.interrupted());
        try {
            MyThread4 myThread4 = new MyThread4();
            myThread4.start();
            Thread.sleep(10L);
            myThread4.interrupt();
            System.out.println("是否停止1：" + myThread4.isInterrupted());
            // System.out.println("是否停止2：" + myThread4.isInterrupted());
            // System.out.println("是否停止3：" + myThread4.isInterrupted());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
