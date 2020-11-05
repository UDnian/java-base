package designpattern.flyweight;

/**
 * @author wangdongxing
 * @since 2020/10/12 12:21 下午
 */
public class FlyWeightMain {
    public static void main(String[] args) {
        ChessFactory chessFactory = ChessFactory.getInstance();
        Chess w = chessFactory.getChess("W");
        Chess w1 = chessFactory.getChess("W");
        System.out.println(w == w1);
        Chess b = chessFactory.getChess("B");
        Chess b1 = chessFactory.getChess("B");
        System.out.println(b == b1);
    }
}
