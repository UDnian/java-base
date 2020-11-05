package designpattern.flyweight;

/**
 * 棋子
 *
 * @author wangdongxing
 * @since 2020/10/12 12:07 下午
 */
public abstract class Chess {
    abstract String getChessColor();
    
    public void display() {
        System.out.println("棋子" + this.getChessColor());
    }
}
