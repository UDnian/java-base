package designpattern.decorator;

/**
 * 浓缩咖啡
 *
 * @author wangdongxing
 * @since 2018/11/12 9:05 PM
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
