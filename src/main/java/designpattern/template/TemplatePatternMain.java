package designpattern.template;

/**
 * 模板方法
 * 定义：在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。
 * 模板方法使得子类可以在不改变算法结构的情况下重新定义算法中的某些步骤。
 * <p>
 * 好莱坞原则：由超类主控一切，当它们需要的时候，自然会去调用子类，这就跟好莱坞一样，别调用我们，我们会调用你。
 * <p>
 * 要点：
 * 1、模板方法定义了算法的步骤，把这些步骤的实现延迟到子类
 * 2、模板方法模式为我们提供了一种代码复用的重要技巧
 * 3、模板方法的抽象类可以定义具体方法、抽象方法和钩子
 * 4、抽象方法由子类实现
 * 5、钩子是一种方法，它在抽象类中不做事，或者只做默认的事情，子类可以选择要不要去覆盖它
 * 6、为了防止子类改变模板方法中的算法，可以将模板方法声明为final
 * 7、好莱坞原则告诉我们，将决策权放在高层模块中，以便决定如何以及何时调用低层模块
 * 8、你将在真实世界代码中看到模板方法模式的许多变体，不要期待它们全过都是一眼就可以被你认出的
 * 9、策略模式和模板方法模式都封装算法，一个用组合，一个用继承
 * 10、工厂方法是模板方法的一版特殊版本
 *
 * @author wangdongxing
 * @since 2018/11/24 10:16 AM
 */
public class TemplatePatternMain {

    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();
        System.out.println();

        CaffeineBeverage coffee = new Coffee();
        coffee.prepareRecipe();
    }

}
