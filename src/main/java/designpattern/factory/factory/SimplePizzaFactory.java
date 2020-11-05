package designpattern.factory.factory;

import designpattern.factory.factory.pizza.CheesePizza;
import designpattern.factory.factory.pizza.ClamPizza;
import designpattern.factory.factory.pizza.Pizza;
import designpattern.factory.factory.pizza.VeggiePizza;

import java.util.Objects;

/**
 * 简单的比萨工厂
 *
 * @author wangdongxing
 * @since 2018/11/14 6:25 PM
 */
public abstract class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (Objects.equals("cheese", type)) {
            pizza = new CheesePizza();
        } else if (Objects.equals("clam", type)) {
            pizza = new ClamPizza();
        } else if (Objects.equals("veggie", type)) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }

}
