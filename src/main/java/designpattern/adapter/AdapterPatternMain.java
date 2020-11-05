package designpattern.adapter;

/**
 * 适配器模式
 * 定义：将一个类的接口，转换成客户期望的另一个接口。适配器让原本接口不兼容的类可以合作无间。
 * <p>
 * 外观模式
 * 定义：提供了一个统一的接口，用来访问子系统中的一群接口。外观定义了一个高层接口，让子系统更容易使用。
 * <p>
 * 最少知识原则：只和你的密友谈话。
 * 理解：当你在设计一个系统，不管是任何对象，你都要注意它所交互的类有哪些，并注意它和这些类是如何交互的。
 * <p>
 * 要点
 * 1、当需要使用一个现有的类而其接口并不符合你的需要时，就使用适配器
 * 2、当需要简化并统一一个很大的接口或者一群复杂的接口时，使用外观
 * 3、适配器改变接口以符合客户的期望
 * 4、外观使客户从一个复杂的子系统中解耦
 * 5、实现一个适配器可能需要一番功夫，也可能不费功夫，视目标接口的大小与复杂度而定
 * 6、实现一个外观，需要将子系统组合进外观中，然后将工作委托给子系统执行
 * 7、适配器有两种形式：对象适配器和类适配器。类适配器需要用到多重继承
 * 8、你可以为一个子系统实现一个以上的外观
 * 9、适配器将一个对象包装起来以改变其接口；装饰者将一个对象包装起来以增加新的行为和责任；而外观将一群对象“包装”起来以简化其接口
 *
 * @author wangdongxing
 * @since 2018/11/21 3:39 PM
 */
public class AdapterPatternMain {

    public static void main(String[] args) {
        Duck duck = new MallardDuck();

        Turkey turkey = new WildTurkey();

        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says...");
        duck.quack();
        duck.fly();

        System.out.println("\nThe TurkeyAdapter says...");
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }

}
