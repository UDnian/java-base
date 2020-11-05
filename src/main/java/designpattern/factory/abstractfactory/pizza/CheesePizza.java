package designpattern.factory.abstractfactory.pizza;

import designpattern.factory.abstractfactory.PizzaIngredientFactory;

/**
 * 奶酪比萨只能使用 纽约风味原料工厂生产的 纽约风味相关原料
 *
 * @author wangdongxing
 * @since 2018/11/16 2:42 PM
 */
public class CheesePizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("准备- " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
    }
}
