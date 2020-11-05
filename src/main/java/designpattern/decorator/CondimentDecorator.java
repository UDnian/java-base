package designpattern.decorator;

/**
 * 调料装饰者
 *
 * @author wangdongxing
 * @since 2018/11/12 9:01 PM
 */
public abstract class CondimentDecorator extends Beverage {

    @Override
    public abstract String getDescription();

}
