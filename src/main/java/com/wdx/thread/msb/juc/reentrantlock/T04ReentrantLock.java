package com.wdx.thread.msb.juc.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangdongxing
 * @since 2020/8/29 12:17 下午
 */
public class T04ReentrantLock {
    
    private Lock lock = new ReentrantLock();
    
    void m1() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("m1..." + i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    
    void m2() {
        try {
            lock.lockInterruptibly();
            System.out.println("m2...");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        T04ReentrantLock t01ReentrantLock = new T04ReentrantLock();
        new Thread(t01ReentrantLock::m1).start();
        TimeUnit.SECONDS.sleep(1);
        Thread thread2 = new Thread(t01ReentrantLock::m2);
        thread2.start();
        TimeUnit.SECONDS.sleep(2);
        thread2.interrupt();
    }
    
}
