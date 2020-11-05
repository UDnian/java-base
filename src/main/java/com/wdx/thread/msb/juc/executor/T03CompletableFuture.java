package com.wdx.thread.msb.juc.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author wangdongxing
 * @since 2020/9/4 5:06 下午
 */
public class T03CompletableFuture {
    
    static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    static String getA() {
        sleep(1);
        System.out.println("A");
        return "A";
    }
    
    static String getB() {
        sleep(2);
        System.out.println("B");
        return "B";
    }
    
    static String getC() {
        sleep(3);
        System.out.println("C");
        return "C";
    }
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> getA());
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> getB());
        CompletableFuture<String> futureC = CompletableFuture.supplyAsync(() -> getC());
        
        CompletableFuture.allOf(futureA, futureB, futureC).join();
        // CompletableFuture.anyOf(futureA, futureB, futureC).join();
        
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000 + "S");
        
        futureA.thenApply(x -> "get" + x).thenAccept(System.out::println);
        sleep(6);
    }
    
}
