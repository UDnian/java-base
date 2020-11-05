package designpattern.factory.abstractfactory;

import designpattern.factory.abstractfactory.pizza.Pizza;

/**
 * 抽象的比萨商店
 *
 * @author wangdongxing
 * @since 2018/11/14 6:00 PM
 */
public abstract class PizzaStore {

    /**
     * 订购比萨
     *
     * @param type 比萨类型
     * @return designpattern.factory.factory.Pizza
     * @author wangdongxing
     * @since 2018/11/14 18:05
     */
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    /**
     * 创建比萨
     *
     * @param type 比萨类型
     * @return designpattern.factory.factory.Pizza
     */
    public abstract Pizza createPizza(String type);
}
