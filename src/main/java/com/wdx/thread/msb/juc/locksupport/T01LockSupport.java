package com.wdx.thread.msb.juc.locksupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * `LockSupport 和 CAS 是 Java 并发包中很多并发工具控制机制的基础，它们底层其实都是依赖 Unsafe 实现。
 * <p>
 * LockSupport 提供 park() 和 unpark() 方法实现阻塞线程和解除线程阻塞。`
 * <p>
 * * LockSupport 是非重入锁；
 * * 锁park与解锁unpark顺序可颠倒性；
 * * 多次锁park相应同等次数解锁unpark后，最后一次的park后代码才能运行；
 *
 * @author wangdongxing
 * @since 2020/9/2 12:07 下午
 */
public class T01LockSupport {
    
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 5) {
                    LockSupport.park();
                    LockSupport.park();
                    LockSupport.park();
                }
                System.out.println(i);
            }
        });
        thread.start();
        
        LockSupport.unpark(thread);
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("main sleep " + i + " s");
            if (i == 7) {
                LockSupport.unpark(thread);
            }
        }
        LockSupport.unpark(thread);
    }
    
}
