package designpattern.strategy.impl;

import designpattern.strategy.FlyBehavior;

/**
 * 用翅膀飞行的实现类
 *
 * @author wangdongxing
 * @since 2018/10/24 3:47 PM
 */
public class FlyWithSwingsImpl implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I am flying with swings...");
    }
}
