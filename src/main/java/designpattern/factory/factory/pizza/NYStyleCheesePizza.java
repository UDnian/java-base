package designpattern.factory.factory.pizza;

/**
 * 纽约风味的奶酪比萨
 *
 * @author wangdongxing
 * @since 2018/11/14 6:11 PM
 */
public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza() {
        name = "纽约奶酪风味的比萨";
        dough = "纽约奶酪风味的面团";
        sauce = "纽约奶酪风味的酱料";
        toppings.add("纽约奶酪风味的佐料");
    }
}
