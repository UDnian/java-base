package com.wdx.thread.msb.juc.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangdongxing
 * @since 2020/8/29 12:17 下午
 */
public class T02ReentrantLock {
    
    private Lock lock = new ReentrantLock();
    
    void m1() {
        lock.lock();
        try {
            for (int i = 0; i < 3; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("m1..." + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    
    void m2() {
        lock.lock();
        try {
            System.out.println("m2...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        T02ReentrantLock t01ReentrantLock = new T02ReentrantLock();
        new Thread(t01ReentrantLock::m1).start();
        // TimeUnit.SECONDS.sleep(1);
        new Thread(t01ReentrantLock::m2).start();
    }
    
}
