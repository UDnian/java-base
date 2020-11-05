package designpattern.factory.factory.pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象 比萨类
 *
 * @author wangdongxing
 * @since 2018/11/14 5:48 PM
 */
public abstract class Pizza {

    protected String name;

    /**
     * 面团
     */
    protected String dough;

    /**
     * 酱料
     */
    protected String sauce;

    /**
     * 一套佐料
     */
    protected List<String> toppings = new ArrayList();

    /**
     * 准备工作
     *
     * @author wangdongxing
     * @since 2018/11/14 17:51
     */
    public void prepare() {
        System.out.println("准备- " + name);
        // 和面
        System.out.println("和面中... " + dough);
        // 加酱料
        System.out.println("加酱料..." + sauce);
        // 加佐料
        System.out.println("Adding toppings: ");
        for (String topping : toppings) {
            System.out.println("    " + topping);
        }
    }

    /**
     * 烘焙
     *
     * @author wangdongxing
     * @since 2018/11/14 17:54
     */
    public void bake() {
        System.out.println("烘焙25分钟");
    }

    /**
     * 切
     *
     * @author wangdongxing
     * @since 2018/11/14 17:55
     */
    public void cut() {
        System.out.println("随便切");
    }

    /**
     * 装盒
     *
     * @author wangdongxing
     * @since 2018/11/14 17:56
     */
    public void box() {
        System.out.println("装盒");
    }
}
