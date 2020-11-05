package designpattern.singleton;

/**
 * @author wangdongxing
 * @since 2019-08-12 11:04
 */
public class SingletonThread {
    private SingletonThread() {
    }

    private static class SingletonHolder {
        private static SingletonThread instance = new SingletonThread();
    }

    private static SingletonThread getInstance() {
        return SingletonHolder.instance;
    }

}
