package designpattern.bridge;

/**
 * @author wangdongxing
 * @since 2020/10/12 10:36 上午
 */
public class TriangleShaper extends Shape {
    
    public TriangleShaper(Color color) {
        super(color);
    }
    
    @Override
    void draw() {
        color.bepaint("三角形");
    }
}
