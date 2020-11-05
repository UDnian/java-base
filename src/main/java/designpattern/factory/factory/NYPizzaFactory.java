package designpattern.factory.factory;

import designpattern.factory.factory.pizza.NYStyleCheesePizza;
import designpattern.factory.factory.pizza.NYStyleClamPizza;
import designpattern.factory.factory.pizza.Pizza;
import designpattern.factory.factory.pizza.VeggiePizza;

import java.util.Objects;

/**
 * 纽约风味的比萨工厂
 *
 * @author wangdongxing
 * @since 2018/11/15 10:45 AM
 */
public class NYPizzaFactory extends SimplePizzaFactory {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (Objects.equals("cheese", type)) {
            pizza = new NYStyleCheesePizza();
        } else if (Objects.equals("clam", type)) {
            pizza = new NYStyleClamPizza();
        } else if (Objects.equals("veggie", type)) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}
