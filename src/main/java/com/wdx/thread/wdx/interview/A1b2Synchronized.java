package com.wdx.thread.wdx.interview;

/**
 * 两个线程交替输出 a1b2c3...
 *
 * @author wangdongxing
 * @since 2019-08-30 13:06
 */
public class A1b2Synchronized {

    public static void main(String[] args) {
        char[] iArray = "123456".toCharArray();
        char[] cArray = "abcdef".toCharArray();

        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                for (char c : iArray) {
                    System.out.println(c);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "thread1").start();

        new Thread(() -> {
            synchronized (lock) {
                for (char c : cArray) {
                    System.out.println(c);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }

        }, "thread2").start();
    }

}
