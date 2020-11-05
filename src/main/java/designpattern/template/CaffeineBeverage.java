package designpattern.template;

/**
 * 咖啡或茶模板抽象类
 * <p>
 * 咖啡和茶都有一样的 烧水、倒入杯子中 的两个步骤
 * 有另外两个 冲泡、添加调味品 不一样步骤
 * 所以一样的为基类实现，不一样的抽象由子类具体实现
 *
 * @author wangdongxing
 * @since 2018/11/23 9:32 AM
 */
public abstract class CaffeineBeverage {

    /**
     * 模板方法
     * 准备食谱
     */
    final void prepareRecipe() {
        // 烧水
        boilWater();
        // 冲泡
        brew();
        // 倒入杯子中
        pourInCup();

        /* 加不加调料品由子类决定，默认是加的 */
        if (hook()) {
            // 添加调味品
            addCondiments();
        }
    }

    /**
     * 烧开水
     */
    void boilWater() {
        System.out.println("水已经开了。。。");
    }

    /**
     * 冲泡
     */
    abstract void brew();

    /**
     * 倒入杯子中
     */
    void pourInCup() {
        System.out.println("把咖啡或饮料倒入杯子中。。。");
    }

    /**
     * 添加调味品
     */
    abstract void addCondiments();

    /**
     * 钩子
     *
     * @return
     */
    boolean hook() {
        return true;
    }

}
