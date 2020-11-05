package designpattern.proxy.staticproxy;

/**
 * @author wangdongxing
 * @since 2020/9/27 5:58 下午
 */
public class ProxyMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal dogProxy = new DogProxy(dog);
        dogProxy.run();
    }
}
