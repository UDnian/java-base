package com.wdx.thread.wdx.test6;

/**
 * 线程锁的是对象
 *
 * @author wangdongxing
 * @since 2019-03-21 08:37
 */
public class ThreadMain6 {

    public static void main(String[] args) {
        MyObject6 myObject6 = new MyObject6();
        MyThreadA6 myThreadA6 = new MyThreadA6(myObject6);
        MyThreadB6 myThreadB6 = new MyThreadB6(myObject6);
        myThreadA6.setName("A");
        myThreadA6.start();
        myThreadB6.setName("B");
        myThreadB6.start();
    }

}
