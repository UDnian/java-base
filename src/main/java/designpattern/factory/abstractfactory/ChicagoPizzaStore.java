package designpattern.factory.abstractfactory;

import designpattern.factory.abstractfactory.pizza.CheesePizza;
import designpattern.factory.abstractfactory.pizza.ClamPizza;
import designpattern.factory.abstractfactory.pizza.Pizza;

import java.util.Objects;

/**
 * 芝加哥比萨店
 *
 * @author wangdongxing
 * @since 2018/11/16 3:13 PM
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        PizzaIngredientFactory factory = new ChicagoIngredientFactory();

        Pizza pizza = null;
        if (Objects.equals("cheese", type)) {
            pizza = new CheesePizza(factory);
            pizza.setName("芝加哥风味奶酪比萨");
        } else if (Objects.equals("clam", type)) {
            pizza = new ClamPizza(factory);
            pizza.setName("芝加哥风味奶酪比萨");
        }
        return pizza;
    }
}
