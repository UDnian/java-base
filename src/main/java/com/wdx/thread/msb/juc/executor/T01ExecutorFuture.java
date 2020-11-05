package com.wdx.thread.msb.juc.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author wangdongxing
 * @since 2020/9/4 3:50 下午
 */
public class T01ExecutorFuture {
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            System.out.println("call...");
            TimeUnit.SECONDS.sleep(3);
            return "Hello World!";
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(callable);
        System.out.println(future.get());
        executor.shutdown();
        System.out.println("main...");
    }
    
}
