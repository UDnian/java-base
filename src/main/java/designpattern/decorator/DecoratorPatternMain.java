package designpattern.decorator;

/**
 * 装饰者模式
 * 定义：动态地将责任附加到对象上。想要扩展功能，装饰者提供有别于继承的另一个选择。
 * 原则：对扩展开放，对修改关闭
 * 要点：
 * 1、继承属于扩展形式之一，但不见得是达到弹性设计的最佳方式
 * 2、在我们的设计中，应该允许行为可以被扩展，而无须修改现有的代码
 * 3、组合和委托可用于在运行时动态地加上新的行为
 * 4、除了继承，装饰者模式也可以让我们扩展行为
 * 5、装饰者模式意为者一群装饰者类，这些类用来包装具体的组件
 * 6、装饰者类反映出被装饰的组件类型（事实上，他们具有相同的类型，都经过接口或继承实现）
 * 7、装饰者可以在被装饰者的行为前面与/或后面加上自己的行为，甚至将被装饰者的行为整个取代掉，而达到特定的目的
 * 8、你可以用无数个装饰者包装一个组件
 * 9、装饰者一般对组件的客户是透明的，除非客户程序依赖于组件的具体类型
 * 10、装饰者会导致设计中出现许多小对象，如果过度使用，会让程序变得很复杂
 *
 * @author wangdongxing
 * @since 2018/11/13 7:38 AM
 */
public class DecoratorPatternMain {

    public static void main(String[] args) {
        /* 一杯加了 摩卡、奶泡的 浓缩咖啡*/
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + ", " + beverage.cost());

        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        System.out.println(beverage.getDescription() + ", " + beverage.cost());

        /* 一杯加了 豆浆 的HouseBlend咖啡 */
        Beverage beverage2 = new HouseBlend();
        System.out.println(beverage2.getDescription() + ", " + beverage2.cost());

        beverage2 = new Soy(beverage2);
        System.out.println(beverage2.getDescription() + ", " + beverage2.cost());
    }

}
