package designpattern.bridge;

/**
 * 定义：
 * 桥梁模式的用意是“将抽象化(Abstraction)与实现化(Implementation)脱耦，使得二者可以独立地变化。
 * 它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。
 * <p>
 * 模式的结构：
 * 抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用。
 * 扩展抽象化（Refined Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
 * 实现化（Implementor）角色：定义实现化角色的接口，供扩展抽象化角色调用。
 * 具体实现化（Concrete Implementor）角色：给出实现化角色接口的具体实现。
 *
 * @author wangdongxing
 * @since 2020/10/12 10:39 上午
 */
public class BridgeMain {
    public static void main(String[] args) {
        Shape squareShape = new SquareShape(new WriteColor());
        squareShape.draw();
        
        Color blackColor = new BlackColor();
        Shape squareShape2 = new SquareShape(blackColor);
        squareShape2.draw();
        
        Shape triangleShaper = new TriangleShaper(blackColor);
        triangleShaper.draw();
    }
    
}
