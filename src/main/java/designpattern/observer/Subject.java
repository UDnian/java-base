package designpattern.observer;

/**
 * 主体
 * 一个主体对应多个观察者
 *
 * @author wangdongxing
 * @since 2018/10/25 6:40 PM
 */
public interface Subject {

    /**
     * 注册观察者
     *
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     *
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();
}
