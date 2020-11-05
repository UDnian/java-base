package com.wdx.thread.wdx.test5;

/**
 * @author wangdongxing
 * @since 2019-03-20 18:39
 */
public class MyThreadB5 extends Thread {

    private HasSelfPrivateNum hasSelfPrivateNum;

    public MyThreadB5(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.addI("b");
    }
}
