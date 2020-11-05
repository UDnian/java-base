package com.wdx.thread.wdx.test5;

/**
 * @author wangdongxing
 * @since 2019-03-20 18:41
 */
public class HasSelfPrivateNum {

    private int num = 0;

    /**
     * synchronized 线程安全的标志
     */
    synchronized public void addI(String username) {
        try {
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over");
                Thread.sleep(5000L);
            } else {
                num = 200;
                System.out.println("b set over");
            }
            System.out.println("username: " + username + ", nmu: " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
