package com.wdx.thread.wdx;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangdongxing
 * @since 2020/4/30 11:16 上午
 */
public final class ThreadUtil {
    
    public static ExecutorService executor() {
        return new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));
    }
    
}
