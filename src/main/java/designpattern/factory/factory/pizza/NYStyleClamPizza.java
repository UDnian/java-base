package designpattern.factory.factory.pizza;

/**
 * 纽约风味的蛤蜊比萨
 *
 * @author wangdongxing
 * @since 2018/11/14 6:11 PM
 */
public class NYStyleClamPizza extends Pizza {

    public NYStyleClamPizza() {
        name = "纽约蛤蜊风味的比萨";
        dough = "纽约蛤蜊风味的面团";
        sauce = "纽约蛤蜊风味的酱料";
        toppings.add("纽约蛤蜊风味的佐料");
    }
}
