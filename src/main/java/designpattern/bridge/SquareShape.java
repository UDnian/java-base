package designpattern.bridge;

/**
 * @author wangdongxing
 * @since 2020/10/12 10:31 上午
 */
public class SquareShape extends Shape {
    
    public SquareShape(Color color) {
        super(color);
    }
    
    @Override
    void draw() {
        color.bepaint("正方形");
    }
}
