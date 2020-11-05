package com.wdx.thread.wdx.future;

import com.wdx.thread.wdx.ThreadUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/**
 * @author wangdongxing
 * @since 2020/4/30 10:43 上午
 */
public class ExecutorServiceFutureMain {
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            System.out.println("test");
            Thread.sleep(3000L);
            return "ok";
        };
        List<FutureTask<String>> futureList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            futureList.add(new FutureTask<>(callable));
        }
        System.out.println(new Date());
        ExecutorService executorService = ThreadUtil.executor();
        // executorService.invokeAll(futureList);
        for (FutureTask<String> task : futureList) {
            executorService.submit(task);
            // String result = task.get();
            // System.out.println(result);
        }
        executorService.shutdown();
    }
    
}
