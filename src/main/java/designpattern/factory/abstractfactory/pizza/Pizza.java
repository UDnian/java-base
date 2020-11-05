package designpattern.factory.abstractfactory.pizza;

import designpattern.factory.abstractfactory.ingredient.Dough;
import designpattern.factory.abstractfactory.ingredient.Sauce;

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
    protected Dough dough;

    /**
     * 酱料
     */
    protected Sauce sauce;

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
    public abstract void prepare();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
