package designpattern.strategy;

/**
 * 模型鸭
 *
 * @author wangdongxing
 * @since 2018/10/25 3:08 PM
 */
public class ModelDuck extends Duck {
    @Override
    public void name() {
        System.out.println("My name is ModelDuck...");
    }
}
