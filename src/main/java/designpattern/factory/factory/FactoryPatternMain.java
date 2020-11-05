package designpattern.factory.factory;

/**
 * 工厂方法模式
 * 定义：定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。工厂方法让类把实例化推迟到子类。
 * 依赖倒置原则：要依赖抽象，不要依赖具体类
 *
 * @author wangdongxing
 * @since 2018/11/15 2:56 PM
 */
public class FactoryPatternMain {

    public static void main(String[] args) {

        String cheese = "cheese";
        PizzaStore nyPizzaStore = new NYPizzaStore();
        nyPizzaStore.orderPizza(cheese);

        String veggie = "veggie";
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        chicagoPizzaStore.orderPizza(veggie);
    }

}
