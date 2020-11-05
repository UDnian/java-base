package designpattern.template;

/**
 * 制作茶
 *
 * @author wangdongxing
 * @since 2018/11/23 10:19 AM
 */
public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("茶冲泡好了。。。");
    }

    @Override
    void addCondiments() {
        System.out.println("加入茶调味品");
    }

    /**
     * 覆盖基类的勾子方法使得不加调料品
     *
     * @return
     */
    @Override
    boolean hook() {
        return false;
    }
}
