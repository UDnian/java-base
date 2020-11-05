package designpattern.factory.factory.pizza;

/**
 * 芝加哥风味的奶酪比萨
 *
 * @author wangdongxing
 * @since 2018/11/15 10:56 AM
 */
public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
        name = "芝加哥风味的奶酪比萨";
        dough = "芝加哥风味的奶酪面团";
        sauce = "芝加哥风味的奶酪酱料";

        toppings.add("芝加哥风味的奶酪佐料");
    }

    @Override
    public void cut() {
        System.out.println("切成方形");
    }
}
