package com.wdx.thread.wdx.test7;

/**
 * 线程锁的是对象
 *
 * @author wangdongxing
 * @since 2019-03-21 08:37
 */
public class ThreadMain7 {

    public static void main(String[] args) {
        MyObject7 myObject7 = new MyObject7();
        MyThreadA7 myThreadA7 = new MyThreadA7(myObject7);
        MyThreadB7 myThreadB7 = new MyThreadB7(myObject7);
        myThreadA7.setName("A");
        myThreadA7.start();
        myThreadB7.setName("B");
        myThreadB7.start();
    }

}
