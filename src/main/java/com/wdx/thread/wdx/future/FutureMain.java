package com.wdx.thread.wdx.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wangdongxing
 * @since 2020/4/30 10:19 上午
 */
public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            System.out.println("test");
            Thread.sleep(3000L);
            return "ok";
        };
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        
        System.out.println("do other thing...");
        
        String result = futureTask.get();
        System.out.println("futureTask return: " + result);
    }
}
