package arithmetic;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU(Least recently used)算法是最近最少使用,根据数据的历史访问记录来进行淘汰数据的。
 * 其核心思想是如果数据最近被访问过，那么将来访问的几率也更高。
 * 在这里提一下，Redis缓存和MyBatis二级缓存更新策略算法中就有LRU。
 * 画外音：LFU是频率最少使用，根据数据历史访问的频率来进行淘汰数据。
 * <p>
 * 通过LinkedHashMap实现LUR算法
 *
 * @author wangdongxing
 * @since 2019-10-29 19:43
 */
public class LURLinkedHashMap {

    public static void main(String[] args) {
        int size = 5;
        Map<String, String> map = new LinkedHashMap<String, String>(size, .75F, false) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                boolean tooBig = size() > size;
                if (tooBig) {
                    System.out.println("最近最少使用的key=" + eldest.getKey());
                }
                return tooBig;
            }
        };

        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        System.out.println(map.toString());

        map.put("6", "6");
        map.get("2");
        map.put("7", "7");
        map.get("4");

        System.out.println(map.toString());

    }

}
