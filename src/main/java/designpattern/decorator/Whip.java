package designpattern.decorator;

/**
 * “奶泡” 调料
 *
 * @author wangdongxing
 * @since 2018/11/13 7:36 AM
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return 0.21 + beverage.cost();
    }
}
