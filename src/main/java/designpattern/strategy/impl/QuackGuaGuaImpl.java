package designpattern.strategy.impl;

import designpattern.strategy.QuackBehavior;

/**
 * 呱呱叫
 *
 * @author wangdongxing
 * @since 2018/10/24 3:50 PM
 */
public class QuackGuaGuaImpl implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("I am quacking gua gua...");
    }
}
