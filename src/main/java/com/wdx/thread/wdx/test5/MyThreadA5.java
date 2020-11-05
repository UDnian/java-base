package com.wdx.thread.wdx.test5;

/**
 * @author wangdongxing
 * @since 2019-03-20 18:39
 */
public class MyThreadA5 extends Thread {

    private HasSelfPrivateNum hasSelfPrivateNum;

    public MyThreadA5(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.addI("a");
    }
}
