package com.wdx.thread.wdx.daemon;

/**
 * @author wangdongxing
 * @since 2019-07-23 11:22
 */
public class DaemonThread {
    
    public static class DaemonDemo implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("i: " + i);
        Runnable daemonDemo = new DaemonDemo();
        Thread thread = new Thread(daemonDemo);
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
