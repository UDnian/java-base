package designpattern.factory.abstractfactory;

import designpattern.factory.abstractfactory.ingredient.ChicagoStyleDough;
import designpattern.factory.abstractfactory.ingredient.ChicagoStyleSauce;
import designpattern.factory.abstractfactory.ingredient.Dough;
import designpattern.factory.abstractfactory.ingredient.Sauce;

/**
 * 芝加哥原料工厂
 *
 * @author wangdongxing
 * @since 2018/11/16 2:39 PM
 */
public class ChicagoIngredientFactory extends PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ChicagoStyleDough();
    }

    @Override
    public Sauce createSauce() {
        return new ChicagoStyleSauce();
    }
}
