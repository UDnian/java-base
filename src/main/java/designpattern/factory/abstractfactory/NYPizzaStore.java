package designpattern.factory.abstractfactory;

import designpattern.factory.abstractfactory.pizza.CheesePizza;
import designpattern.factory.abstractfactory.pizza.ClamPizza;
import designpattern.factory.abstractfactory.pizza.Pizza;

import java.util.Objects;

/**
 * 纽约比萨店
 *
 * @author wangdongxing
 * @since 2018/11/16 3:04 PM
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        // 纽约比萨店只使用纽约原料工厂来生产原料
        PizzaIngredientFactory factory = new NYPizzaIngredientFactory();

        Pizza pizza = null;
        if (Objects.equals("cheese", type)) {
            // 把工厂传递给比萨，方便比萨从工厂取出原料
            pizza = new CheesePizza(factory);
            pizza.setName("纽约风味奶酪比萨");
        } else if (Objects.equals("clam", type)) {
            pizza = new ClamPizza(factory);
            pizza.setName("纽约风味哈唎比萨");
        }

        return pizza;
    }
}
