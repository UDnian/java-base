package designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangdongxing
 * @since 2020/10/12 12:10 下午
 */
public final class ChessFactory {
    private static final ChessFactory CHESS_FACTORY = new ChessFactory();
    
    private final Map<String, Chess> cache = new HashMap<>();
    
    private ChessFactory() {
    }
    
    public static ChessFactory getInstance() {
        return CHESS_FACTORY;
    }
    
    public Chess getChess(String s) {
        Chess chess = cache.get(s);
        if (chess == null) {
            switch (s) {
                case "W":
                    chess = new WriteChess();
                    break;
                case "B":
                    chess = new BlackChess();
                    break;
                default:
                    break;
            }
        }
        if (chess != null) {
            cache.put(s, chess);
        }
        return chess;
    }
}
