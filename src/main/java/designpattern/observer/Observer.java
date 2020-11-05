package designpattern.observer;

/**
 * 观察者接口
 *
 * @author wangdongxing
 * @since 2018/10/25 6:41 PM
 */
public interface Observer {

    /**
     * 修改 温度、湿度、压力
     *
     * @param temperature
     * @param humidity
     * @param pressure
     */
    void update(float temperature, float humidity, float pressure);
}
