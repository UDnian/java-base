package com.wdx.thread.msb.juc.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangdongxing
 * @since 2020/9/4 7:55 下午
 */
public class T04ThreadPoolExecutor {
    
    static class Task implements Runnable {
        private int num;
        
        Task(int num) {
            this.num = num;
        }
        
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + num);
        }
        
        @Override
        public String toString() {
            return "task " + num;
        }
    }
    
    public static void main(String[] args) {
        // 核心线程数
        int corePoolSize = 4;
        // 最大线程数(核心线程全部被占用，且任务队列满时，拓展非核心线程数量不超过最大线程数)
        int maximumPoolSize = 6;
        // 非核心线程闲置时回收时长
        int keepAliveTime = 60;
        TimeUnit seconds = TimeUnit.SECONDS;
        // 任务队列
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(3);
        // 线程工厂
        ThreadFactory threadFactory = new MyThreadFactory("myTest");
        // 最大线程数全部占用，且任务队列已满时，再来新任务时的处理策略
        MyPolicy myPolicy = new MyPolicy();
        
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, seconds,
                queue, threadFactory, myPolicy);
        
        for (int i = 0; i < 10; i++) {
            executor.execute(new Task(i));
        }
        
        // Future<String> future = executor.submit(() -> {
        //     return "OK";
        // });
        executor.shutdown();
    }
    
    /**
     * 自定义线程工厂
     */
    static class MyThreadFactory implements ThreadFactory {
        
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        
        private final ThreadGroup group;
        
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        
        private final String namePrefix;
        
        MyThreadFactory(String taskName) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" + POOL_NUMBER.getAndIncrement() + "-thread-" + taskName + "-";
        }
        
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }
    
    /**
     * 多余任务的处理策略
     */
    static class MyPolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(r);
        }
    }
    
}
