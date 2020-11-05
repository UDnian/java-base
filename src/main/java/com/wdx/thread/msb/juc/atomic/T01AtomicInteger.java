package com.wdx.thread.msb.juc.atomic;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger测试
 *
 * @author wangdongxing
 * @since 2020/8/28 7:31 下午
 */
public class T01AtomicInteger {
    
    private int ii = 0;
    
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    
    void add() {
        for (int i = 0; i < 10000; i++) {
            // ii++;
            atomicInteger.incrementAndGet();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        T01AtomicInteger t01AtomicInteger = new T01AtomicInteger();
        
        ArrayList<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(t01AtomicInteger::add));
        }
        threadList.forEach(Thread::start);
        for (Thread thread : threadList) {
            thread.join();
        }
        
        // System.out.println(t01AtomicInteger.ii);
        System.out.println(t01AtomicInteger.atomicInteger);
    }
    
}
