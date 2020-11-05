package designpattern.factory.abstractfactory;

import designpattern.factory.abstractfactory.ingredient.Dough;
import designpattern.factory.abstractfactory.ingredient.Sauce;

/**
 * 比萨原料工厂
 *
 * @author wangdongxing
 * @since 2018/11/16 10:54 AM
 */
public abstract class PizzaIngredientFactory {

    public abstract Dough createDough();

    public abstract Sauce createSauce();

}
