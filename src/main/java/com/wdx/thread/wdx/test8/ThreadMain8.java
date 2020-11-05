package com.wdx.thread.wdx.test8;

/**
 * 线程锁的是对象
 *
 * @author wangdongxing
 * @since 2019-03-21 08:37
 */
public class ThreadMain8 {

    public static void main(String[] args) {
        Task8 task8 = new Task8();
        MyThreadA8 myThreadA8 = new MyThreadA8(task8);
        MyThreadB8 myThreadB8 = new MyThreadB8(task8);
        myThreadA8.setName("A");
        myThreadA8.start();
        myThreadB8.setName("B");
        myThreadB8.start();
    }

}
