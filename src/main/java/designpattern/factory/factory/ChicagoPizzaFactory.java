package designpattern.factory.factory;

import designpattern.factory.factory.pizza.ChicagoStyleCheesePizza;
import designpattern.factory.factory.pizza.ChicagoStyleVeggiePizza;
import designpattern.factory.factory.pizza.ClamPizza;
import designpattern.factory.factory.pizza.Pizza;

import java.util.Objects;

/**
 * @author wangdongxing
 * @since 2018/11/15 3:01 PM
 */
public class ChicagoPizzaFactory extends SimplePizzaFactory {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (Objects.equals("cheese", type)) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (Objects.equals("clam", type)) {
            pizza = new ClamPizza();
        } else if (Objects.equals("veggie", type)) {
            pizza = new ChicagoStyleVeggiePizza();
        }

        return pizza;
    }
}
