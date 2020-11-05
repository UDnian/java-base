package designpattern.bridge;

/**
 * @author wangdongxing
 * @since 2020/10/12 10:13 上午
 */
public abstract class Shape {
    protected Color color;
    
    public Shape(Color color) {
        this.color = color;
    }
    
    abstract void draw();
}
