package designpattern.decorator;

/**
 * 又一种咖啡饮料
 *
 * @author wangdongxing
 * @since 2018/11/12 9:28 PM
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
