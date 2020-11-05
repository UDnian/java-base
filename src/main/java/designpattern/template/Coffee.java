package designpattern.template;

/**
 * 制作咖啡
 *
 * @author wangdongxing
 * @since 2018/11/23 10:18 AM
 */
public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("咖啡冲泡好了。。。");
    }

    @Override
    void addCondiments() {
        System.out.println("加咖啡调味。。。");
    }
}
