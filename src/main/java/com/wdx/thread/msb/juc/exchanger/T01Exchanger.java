package com.wdx.thread.msb.juc.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * Exchanger类可用于两个线程之间交换信息。
 * 可简单地将Exchanger对象理解为一个包含两个格子的容器，通过exchanger方法可以向两个格子中填充信息。
 * 当两个格子中的均被填充时，该对象会自动将两个格子的信息交换，然后返回给线程，从而实现两个线程的信息交换。
 *
 * @author wangdongxing
 * @since 2020/9/2 11:41 上午
 */
public class T01Exchanger {
    
    private static Exchanger<String> EXCHANGER = new Exchanger<>();
    
    public static void main(String[] args) {
        new Thread(() -> {
            String s = "T1";
            try {
                String exchange = EXCHANGER.exchange(s);
                System.out.println(Thread.currentThread().getName() + " old: " + s + "; new: " + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1 thread").start();
        
        new Thread(() -> {
            String s = "T2";
            try {
                TimeUnit.SECONDS.sleep(1L);
                String exchange = EXCHANGER.exchange(s);
                System.out.println(Thread.currentThread().getName() + " old: " + s + "; new: " + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2 thread").start();
    }
}
