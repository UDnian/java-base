package designpattern.factory.factory.pizza;

/**
 * 素食比萨
 *
 * @author wangdongxing
 * @since 2018/11/15 8:59 AM
 */
public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        name = "素食的比萨";
        dough = "素食的面团";
        sauce = "素食的酱料";
        toppings.add("素食的佐料");
    }
}
