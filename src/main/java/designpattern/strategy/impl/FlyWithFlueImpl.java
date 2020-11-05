package designpattern.strategy.impl;

import designpattern.strategy.FlyBehavior;

/**
 * 依靠燃料飞行的实现类
 *
 * @author wangdongxing
 * @since 2018/10/25 11:24 AM
 */
public class FlyWithFlueImpl implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I am flying with flue...");
    }
}
