package designpattern.strategy;

/**
 * @author wangdongxing
 * @since 2018/10/24 9:28 AM
 */
public abstract class Duck {

    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    /**
     * 所有鸭子的公共相同方法
     *
     * @return void
     * @author wangdongxing
     * @since 2018/10/25 14:27
     */
    public void swim() {
        System.err.println("swimming...");
    }

    /**
     * 所有鸭子的公共方法 但实现不同
     *
     * @return void
     * @author wangdongxing
     * @since 2018/10/25 14:27
     */
    public abstract void name();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
