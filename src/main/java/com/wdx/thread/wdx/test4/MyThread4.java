package com.wdx.thread.wdx.test4;

/**
 * @author wangdongxing
 * @since 2019-03-20 08:55
 */
public class MyThread4 extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("线程被中止，我要退出了");
                    // 抛出异常可以阻止for循环外的语句执行
                    throw new InterruptedException();
                }
                System.out.println("i = " + i);
            }
            System.out.println("我被输出了，除for循环外，其他依旧运行");
        } catch (InterruptedException e) {
            System.out.println("进入到了catch中");
            e.printStackTrace();
        }
    }
}
