package com.wdx.thread.msb.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * count + down + latch ＝ 计数 ＋ 减 ＋ 门闩，可以理解这个东西就是个计数器，只能减不能加，同时它还有个门闩的作用；
 * 当计数器不为0时，门闩是锁着的；当计数器减到0时，门闩就打开了。
 * <p>
 * 可以类比考生考试交卷，考生交一份试卷，计数器就减一。直到考生都交了试卷（计数器为0），监考老师（一个或多个）才能离开考场。
 * 至于考生是否做完试卷，监考老师并不关注。只要都交了试卷，他就可以做接下来的工作了。
 *
 * @author wangdongxing
 * @since 2020/8/29 5:25 下午
 */
public class T01CountDownLatch {
    
    private CountDownLatch latch = new CountDownLatch(10);
    
    void m() {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + "countDown " + latch.getCount());
            }, "第" + i + "个thread ");
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
    
    void m1() {
        System.out.println("m1 begin...");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 end...");
    }
    
    public static void main(String[] args) throws InterruptedException {
        T01CountDownLatch t01CountDownLatch = new T01CountDownLatch();
        new Thread(() -> t01CountDownLatch.m()).start();
        new Thread(() -> t01CountDownLatch.m1()).start();
        // t01CountDownLatch.m();
        // t01CountDownLatch.m1();
    }
    
}
