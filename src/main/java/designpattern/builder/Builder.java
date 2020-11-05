package designpattern.builder;

/**
 * 抽象建造者
 *
 * @author wangdongxing
 * @since 2020/9/27 3:29 下午
 */
public abstract class Builder {
    //汉堡
    abstract Builder buildA(String mes);
    
    //饮料
    abstract Builder buildB(String mes);
    
    //薯条
    abstract Builder buildC(String mes);
    
    //甜品
    abstract Builder buildD(String mes);
    
    //获取套餐
    abstract Product build();
}
