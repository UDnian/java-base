package com.wdx.thread.msb.juc.reentrantlock;

import java.util.concurrent.TimeUnit;

/**
 * @author wangdongxing
 * @since 2020/8/29 12:17 下午
 */
public class T01ReentrantLock {
    
    synchronized void m1() {
        for (int i = 0; i < 3; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m1..." + i);
        }
    }
    
    synchronized void m2() {
        System.out.println("m2...");
    }
    
    public static void main(String[] args) throws InterruptedException {
        T01ReentrantLock t01ReentrantLock = new T01ReentrantLock();
        new Thread(t01ReentrantLock::m1).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(t01ReentrantLock::m2).start();
    }
    
}
