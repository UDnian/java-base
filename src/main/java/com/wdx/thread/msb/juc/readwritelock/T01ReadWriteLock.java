package com.wdx.thread.msb.juc.readwritelock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 一个对象的两个方法：读和写；
 * 使用Synchronized存在明显的一个性能问题就是读与读之间互斥，会影响效率；
 * 简言之就，实现的最好效果是，可以做到读和读互不影响，读和写互斥，写和写互斥，提高读写的效率 可使用ReadWriteLock
 *
 * @author wangdongxing
 * @since 2020/9/1 6:28 下午
 */
public class T01ReadWriteLock {
    
    private int value;
    
    private final Lock lock = new ReentrantLock();
    
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    
    private final ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    
    private final ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
    
    void read(Lock lockParam) {
        lockParam.lock();
        try {
            System.out.println("read... value " + value);
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockParam.unlock();
        }
    }
    
    void write(Lock lockParam, int value) {
        lockParam.lock();
        try {
            this.value = value;
            System.out.println("write... value " + value);
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockParam.unlock();
        }
    }
    
    public static void main(String[] args) {
        T01ReadWriteLock t01ReadWriteLock = new T01ReadWriteLock();
        Runnable readRunnable = () -> {
            // t01ReadWriteLock.read(t01ReadWriteLock.lock);
            t01ReadWriteLock.read(t01ReadWriteLock.readLock);
        };
        Runnable writeRunnable = () -> {
            // t01ReadWriteLock.write(t01ReadWriteLock.lock);
            Random random = new Random();
            t01ReadWriteLock.write(t01ReadWriteLock.writeLock, random.nextInt(10));
        };
        for (int i = 0; i < 2; i++) {
            new Thread(writeRunnable).start();
        }
        for (int i = 0; i < 8; i++) {
            new Thread(readRunnable).start();
        }
        
    }
    
}
