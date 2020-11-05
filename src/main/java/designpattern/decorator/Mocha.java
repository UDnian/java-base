package designpattern.decorator;

/**
 * “摩卡” 装饰者
 *
 * @author wangdongxing
 * @since 2018/11/12 9:34 PM
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}
