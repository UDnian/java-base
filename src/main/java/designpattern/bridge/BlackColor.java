package designpattern.bridge;

/**
 * @author wangdongxing
 * @since 2020/10/12 10:34 上午
 */
public class BlackColor implements Color {
    @Override
    public void bepaint(String shape) {
        System.out.println("黑色的" + shape);
    }
}
