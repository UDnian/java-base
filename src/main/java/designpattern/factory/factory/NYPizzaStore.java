package designpattern.factory.factory;

import designpattern.factory.factory.pizza.Pizza;

/**
 * @author wangdongxing
 * @since 2018/11/15 2:46 PM
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        SimplePizzaFactory factory = new NYPizzaFactory();
        return factory.createPizza(type);
    }
}
