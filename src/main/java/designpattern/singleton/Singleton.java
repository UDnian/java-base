package designpattern.singleton;

/**
 * 单件模式
 * 定义：确保一个类只有一个实例，并提供全局访问点
 * 要点
 * 1、单件模式确保程序中一个类最多只有一个实例
 * 2、单件模式也提供访问这个实例的全局点
 * 3、实现单件模式需要么有的构造器、一个静态方法、一个静态变量
 * 4、确定在性能和资源上的限制，然后小心地选择适当的方案来实现单件，以解决多线程问题（我们必须认定所有的程序都是多线程的）
 * 5、小心，如果使用多个类加载器，可能导致单件失效而产生多个实例
 *
 * @author wangdongxing
 * @since 2018/11/16 4:47 PM
 */
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}
