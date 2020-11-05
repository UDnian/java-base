package designpattern.builder;

/**
 * 建造者模式
 * 1、定义：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。由产品、抽象建造者、具体建造者、指挥者等 4 个要素构成。
 * 2、主要作用：在用户不知道对象的建造过程和细节的情况下就可以直接创建复杂的对象。
 * 3、如何使用：用户只需要给出指定复杂对象的类型和内容，建造者模式负责按顺序创建复杂对象（把内部的建造过程和细节隐藏起来）
 * 4、解决的问题：
 * （1）、方便用户创建复杂的对象（不需要知道实现过程）
 * （2）、代码复用性 & 封装性（将对象构建过程和细节进行封装 & 复用）
 * 5、注意事项：与工厂模式的区别是：建造者模式更加关注与零件装配的顺序，一般用来创建更为复杂的对象。工厂方法模式更注重零部件的创建过程，但两者可以结合使用
 * <p>
 * 指挥者可以由客户Main代替，更灵活
 *
 * @author wangdongxing
 * @since 2020/9/27 3:22 下午
 */
public class BuilderMain {
    
    public static void main(String[] args) {
        Builder builder = new WaiterBuilder();
        Product product = builder.buildA("奥尔良鸡肉汉堡").buildB("可乐").buildD("JJ蛋糕").build();
        System.out.println(product);
    }
    
}
