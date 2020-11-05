package designpattern.proxy.staticproxy;

/**
 * @author wangdongxing
 * @since 2020/9/27 5:56 下午
 */
public class DogProxy extends Animal {
    
    private Animal dog;
    
    public DogProxy(Animal dog) {
        this.dog = dog;
    }
    
    @Override
    void run() {
        System.out.println("run before...");
        dog.run();
        System.out.println("run after...");
    }
}
