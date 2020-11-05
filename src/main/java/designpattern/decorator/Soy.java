package designpattern.decorator;

/**
 * “豆浆” 调料
 *
 * @author wangdongxing
 * @since 2018/11/13 7:34 AM
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return 0.12 + beverage.cost();
    }
}
