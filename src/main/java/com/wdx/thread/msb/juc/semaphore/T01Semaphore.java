package com.wdx.thread.msb.juc.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore是一种基于计数的信号量。它可以设定一个阈值，基于此，多个线程竞争获取许可信号，做完自己的申请后归还，超过阈值后，线程申请许可信号将会被阻塞。
 * 可以用来构建一些对象池，资源池之类的，比如数据库连接池，我们也可以创建计数为1的Semaphore，将其作为一种类似互斥锁的机制，这也叫二元信号量，表示两种互斥状态。
 *
 * @author wangdongxing
 * @since 2020/9/1 7:31 下午
 */
public class T01Semaphore {
    
    private final Semaphore semaphore = new Semaphore(2);
    
    void m() {
        try {
            semaphore.acquire();
            TimeUnit.SECONDS.sleep(1L);
            System.out.println("m...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        T01Semaphore t01Semaphore = new T01Semaphore();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(t01Semaphore::m);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        long time2 = System.currentTimeMillis();
        System.out.println("耗时: " + (time2 - time1) / 1000 + " 秒");
    }
    
}
