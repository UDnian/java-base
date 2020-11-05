package com.wdx.thread.msb.juc.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author wangdongxing
 * @since 2020/9/4 4:12 下午
 */
public class T02FutureTask {
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(3L);
            return "Hello World!";
        });
        System.out.println("start...");
        new Thread(futureTask).start();
        // ExecutorService executor = Executors.newCachedThreadPool();
        // executor.submit(futureTask);
        // executor.shutdown();
        String s = futureTask.get();
        System.out.println(s);
        System.out.println("main....");
    }
    
}
