package com.wdx.thread.wdx.test9;

/**
 * @author wangdongxing
 * @since 2019-03-22 17:18
 */
public class ThreadMain9 {

    public static void main(String[] args) {
        MyObject9 myObject9 = new MyObject9();
        MyThreadA9 myThreadA9 = new MyThreadA9(myObject9);
        MyThreadB9 myThreadB9 = new MyThreadB9(myObject9);
        myThreadA9.setName("A");
        myThreadA9.start();
        myThreadB9.setName("B");
        myThreadB9.start();
    }

}
