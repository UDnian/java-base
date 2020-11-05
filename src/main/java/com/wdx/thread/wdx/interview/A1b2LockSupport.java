package com.wdx.thread.wdx.interview;

import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程交替输出 a1b2c3...
 *
 * @author wangdongxing
 * @since 2019-08-30 13:06
 */
public class A1b2LockSupport {
    
    static Thread thread1 = null;
    
    static Thread thread2 = null;
    
    public static void main(String[] args) {
        char[] iArray = "123456".toCharArray();
        char[] cArray = "abcdef".toCharArray();
        
        thread1 = new Thread(() -> {
            for (char c : iArray) {
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(thread2);
            }
        }, "thread1");
        
        thread2 = new Thread(() -> {
            for (char c : cArray) {
                System.out.println(c);
                LockSupport.unpark(thread1);
                LockSupport.park();
            }
        }, "thread2");
        
        thread1.start();
        thread2.start();
    }
    
}
