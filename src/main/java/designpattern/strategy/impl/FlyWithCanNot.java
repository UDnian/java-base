package designpattern.strategy.impl;

import designpattern.strategy.FlyBehavior;

/**
 * @author wangdongxing
 * @since 2018/10/25 3:09 PM
 */
public class FlyWithCanNot implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can not fly...");
    }
}
