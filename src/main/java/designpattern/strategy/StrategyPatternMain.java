package designpattern.strategy;

import designpattern.strategy.impl.FlyWithCanNot;
import designpattern.strategy.impl.FlyWithFlueImpl;
import designpattern.strategy.impl.FlyWithSwingsImpl;
import designpattern.strategy.impl.QuackGuaGuaImpl;

/**
 * 策略模式（Strategy Pattern）
 * 定义：定义了算法族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化独立于使用算法的客户
 * 涉及的设计原则：
 * 1、找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起
 * 2、针对接口编程，而不是针对实现编程
 * 3、多用组合，少用继承
 * 要点：
 * 1、知道OO基础，并不足以让你设计良好的OO系统
 * 2、良好的OO设计必须具备可复用、可扩充、可维护三个特性
 * 3、模式可以让我们建造出具有良好OO设计质量的系统
 * 4、模式被认为是历经验证的OO设计经验
 * 5、模式不是代码，而是针对设计问题的能用解决方案。你可把它们应用到特定的应用中
 * 6、模式不是被发明，而是被发现
 * 7、大多数的模式和原则，都着眼于软件变化的主题
 * 8、大多数的模式都允许系统局部改变独立于其他部分
 * 9、我们常把系统中会变化的部分抽出来封装
 * 10、模式让开发人员之间有共享的语言，能够最大化沟通的价值
 *
 * @author wangdongxing
 * @since 2018/10/23 5:27 PM
 */
public class StrategyPatternMain {

    public static void main(String[] args) {
        Duck rocketDuck = new RocketDuck();
        rocketDuck.name();
        // 动态定义火箭鸭的飞行方式-燃料飞行
        rocketDuck.setFlyBehavior(new FlyWithFlueImpl());
        rocketDuck.performFly();

        // 动态定义火箭鸭的飞行方式-翅膀飞行
        rocketDuck.setFlyBehavior(new FlyWithSwingsImpl());
        rocketDuck.performFly();

        // 动态定义火箭鸭的鸣叫方式-呱呱叫
        rocketDuck.setQuackBehavior(new QuackGuaGuaImpl());
        rocketDuck.performQuack();

        Duck modelDuck = new ModelDuck();
        modelDuck.name();
        // 动态定义火箭鸭的鸣叫方式-呱呱叫
        modelDuck.setFlyBehavior(new FlyWithCanNot());
        modelDuck.performFly();
    }

}
