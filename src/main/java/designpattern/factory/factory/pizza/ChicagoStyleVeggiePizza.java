package designpattern.factory.factory.pizza;

/**
 * 芝加哥风味素食比萨
 *
 * @author wangdongxing
 * @since 2018/11/15 3:03 PM
 */
public class ChicagoStyleVeggiePizza extends Pizza {

    public ChicagoStyleVeggiePizza() {
        name = "芝加哥风味的素食比萨";
        dough = "芝加哥风味的素食面团";
        sauce = "芝加哥风味的素食酱料";

        toppings.add("芝加哥风味的素食佐料");
    }

    @Override
    public void cut() {
        System.out.println("切成菱形");
    }
}
