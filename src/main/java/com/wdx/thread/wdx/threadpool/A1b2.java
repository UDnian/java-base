package com.wdx.thread.wdx.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 两个线程交替输出 a1b2c3...
 *
 * @author wangdongxing
 * @since 2019-08-30 13:06
 */
public class A1b2 {
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        char[] iArray = "1234567".toCharArray();
        char[] cArray = "abcdefg".toCharArray();
        
        Runnable runnable1 = () -> {
            for (char c : iArray) {
                System.out.println(Thread.currentThread().getName() + " " + c);
            }
        };
        
        Runnable runnable2 = () -> {
            for (char c : cArray) {
                System.out.println(Thread.currentThread().getName() + " " + c);
            }
        };
        
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(512), r -> new Thread(r, "my thread"));
        Future<String> future = threadPoolExecutor.submit(runnable1, "123");
        threadPoolExecutor.submit(runnable2);
        String s = future.get();
        System.out.println(s);
        threadPoolExecutor.shutdown();
    }
    
}
