package designpattern.factory.abstractfactory;

import designpattern.factory.abstractfactory.ingredient.Dough;
import designpattern.factory.abstractfactory.ingredient.NYStyleDough;
import designpattern.factory.abstractfactory.ingredient.NYStyleSauce;
import designpattern.factory.abstractfactory.ingredient.Sauce;

/**
 * 纽约比萨原料工厂
 *
 * @author wangdongxing
 * @since 2018/11/16 11:27 AM
 */
public class NYPizzaIngredientFactory extends PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new NYStyleDough();
    }

    @Override
    public Sauce createSauce() {
        return new NYStyleSauce();
    }
}
