package designpattern.factory.abstractfactory.pizza;

import designpattern.factory.abstractfactory.PizzaIngredientFactory;

/**
 * 哈唎比萨
 *
 * @author wangdongxing
 * @since 2018/11/16 2:56 PM
 */
public class ClamPizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;

    public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("准备- " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
    }
}
