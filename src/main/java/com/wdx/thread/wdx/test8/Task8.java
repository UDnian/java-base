package com.wdx.thread.wdx.test8;

/**
 * @author wangdongxing
 * @since 2019-03-22 16:18
 */
public class Task8 {

    public void doLongTimeTask() {
        for (int i = 0; i < 100; i++) {
            System.out.println("no synchronized threadName= " + Thread.currentThread().getName() + " i= " + (i + 1));
        }
        System.out.println();
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized threadName= " + Thread.currentThread().getName() + " i= " + (i + 1));
            }
        }
    }

}
