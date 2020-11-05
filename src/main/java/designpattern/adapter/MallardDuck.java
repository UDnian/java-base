package designpattern.adapter;

/**
 * 绿头鸭
 *
 * @author wangdongxing
 * @since 2018/11/21 3:35 PM
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
