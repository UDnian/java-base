package designpattern.adapter;

/**
 * 野鸡
 *
 * @author wangdongxing
 * @since 2018/11/21 3:36 PM
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
