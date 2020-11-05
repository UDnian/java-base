package com.wdx.thread.msb.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author wangdongxing
 * @since 2020/8/28 10:55 上午
 */
public class T01WhatIsThread {
    
    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "===" + i);
                    TimeUnit.SECONDS.sleep(1L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    static class MyRunable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "@@@" + i);
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        /* 创建线程并启动的方式 */
        
        // 1、继承Thread类
        MyThread myThread = new MyThread();
        myThread.start();
        
        // 2、实现Runable
        // new Thread(new MyRunable(), "runnable").start();
        
        // 3、lambda表达式（其实是2的变种）
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    if (i == 5) {
                        myThread.join();
                    }
                    System.out.println(Thread.currentThread().getName() + "===" + i);
                    TimeUnit.SECONDS.sleep(1L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "lambda").start();
    }
}
