package com.wdx.thread.wdx.test5;

/**
 * @author wangdongxing
 * @since 2019-03-20 18:39
 */
public class ThreadMain5 {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum1 = new HasSelfPrivateNum();
        HasSelfPrivateNum hasSelfPrivateNum2 = new HasSelfPrivateNum();
        MyThreadA5 myThreadA5 = new MyThreadA5(hasSelfPrivateNum1);
        MyThreadB5 myThreadB5 = new MyThreadB5(hasSelfPrivateNum2);
        myThreadA5.start();
        myThreadB5.start();
    }
}
