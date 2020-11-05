package com.wdx.thread.wdx;

/**
 * @author wangdongxing
 * @since 2020/7/23 4:41 下午
 */
public class ThreadTest {
    
    //    private static Logger LOGGER = LoggerFactory.getLogger(ThreadTest.class);
    
    private static volatile boolean FLAG = false;
    
    private static void refresh() {
        System.out.println("开始刷新 原始值 FLAG: " + FLAG);
        //        LOGGER.info("开始刷新 原始值 FLAG: {}", FLAG);
        FLAG = true;
        //        LOGGER.info("刷新成功 FLAG: {}", FLAG);
        System.out.println("刷新成功 FLAG: " + FLAG);
    }
    
    public static void load() {
        System.out.println("无限输出开始 FLAG: " + FLAG);
        while (!FLAG) {
            //            System.out.println(111);
            //            LOGGER.info("无限输出。。。。 FLAG: {}", FLAG);
        }
        //        LOGGER.info("无限输出结束 FLAG: {}", FLAG);
        System.out.println("无限输出结束 FLAG: " + FLAG);
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        new Thread(() -> {
            load();
        }).start();
        
        Thread.sleep(100L);
        
        new Thread(() -> {
            refresh();
        }).start();
    }
    
}
