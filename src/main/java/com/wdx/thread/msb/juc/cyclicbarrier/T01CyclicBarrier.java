package com.wdx.thread.msb.juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier可以使一定数量的线程反复地在栅栏位置处汇集。当线程到达栅栏位置时将调用await方法，这个方法将阻塞直到所有线程都到达栅栏位置。
 * 如果所有线程都到达栅栏位置，那么栅栏将打开，此时所有的线程都将被释放，而栅栏将被重置以便下次使用。
 *
 * @author wangdongxing
 * @since 2020/9/1 5:27 下午
 */
public class T01CyclicBarrier {
    
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("满人发车。。。");
        });
        
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    System.out.println("来人啦");
                    int await = cyclicBarrier.await();
                    System.out.println("await " + await);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
