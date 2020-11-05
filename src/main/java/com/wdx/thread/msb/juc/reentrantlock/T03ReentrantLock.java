package com.wdx.thread.msb.juc.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangdongxing
 * @since 2020/8/29 12:17 下午
 */
public class T03ReentrantLock {
    
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
        boolean tryLock = false;
        try {
            tryLock = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (tryLock) {
                lock.unlock();
            }
        }
        System.out.println("tryLock..." + tryLock);
        System.out.println("m2...");
    }
    
    public static void main(String[] args) throws InterruptedException {
        T03ReentrantLock t01ReentrantLock = new T03ReentrantLock();
        new Thread(t01ReentrantLock::m1).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(t01ReentrantLock::m2).start();
    }
    
}
