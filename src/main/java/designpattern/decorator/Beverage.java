package designpattern.decorator;

/**
 * “饮料”超类
 *
 * @author wangdongxing
 * @since 2018/11/12 8:55 PM
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
