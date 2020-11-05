package designpattern.factory.factory;

import designpattern.factory.factory.pizza.Pizza;

/**
 * 芝加哥比萨
 *
 * @author wangdongxing
 * @since 2018/11/15 2:59 PM
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        SimplePizzaFactory factory = new ChicagoPizzaFactory();
        return factory.createPizza(type);
    }
}
