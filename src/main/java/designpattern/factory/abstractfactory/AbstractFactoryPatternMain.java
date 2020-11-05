package designpattern.factory.abstractfactory;

/**
 * @author wangdongxing
 * @since 2018/11/16 3:28 PM
 */
public class AbstractFactoryPatternMain {

    public static void main(String[] args) {
        PizzaStore store = new NYPizzaStore();
        store.orderPizza("cheese");

        PizzaStore store2 = new ChicagoPizzaStore();
        store2.orderPizza("clam");
    }

}
