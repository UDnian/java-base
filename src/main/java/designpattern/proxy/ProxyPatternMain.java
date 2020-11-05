package designpattern.proxy;

/**
 * 代理模式
 * 定义：为另一个对象提供一个替身或占位符以访问这个对象。
 * <p>
 * 要点
 * 1、代理模式为另一个对象提供代表，以便控制客户对对象的访问，管理访问的方式有许多种
 * 2、远程代理管理客户和远程对象之间的交互
 * 3、虚拟代理控制访问实例化开销大的对象
 * 4、保护代理基于调用者控制对对象方法的访问
 * 5、代理模式有许多变体，例如：缓存代理、同步代理、防火墙代理和写入时复制代理
 * 6、代理在结构上类似装饰者，但是目的不同
 * 7、装饰者模式为对象加上行为，而代理则是控制访问
 * 8、java内置的代理支持，可以根据需要建立动态代理，并将所有调用分配到所选的处理器
 * 9、就和其他的包装者（wrapper）一样，代理会造成你的设计中类的数目增加
 *
 * @author wangdongxing
 * @since 2018-12-03 20:39
 */
public class ProxyPatternMain {
    
    public static void main(String[] args) {
        ProxyPatternMain proxyPatternMain = new ProxyPatternMain();
        proxyPatternMain.test();
    }
    
    private void test() {
        PersonBean wang = new PersonBeanImpl("wang");
        PersonBean ownerProxy = ProxyFactory.getOwnerProxy(wang);
        System.out.println("Name is " + ownerProxy.getName());
        ownerProxy.setInterests("football");
        try {
            ownerProxy.setHotOrNotRating(100);
        } catch (Exception e) {
            System.out.println("不能为自己打分");
        }
        System.out.println(wang);
        System.out.println();
        
        PersonBeanImpl zhao = new PersonBeanImpl("zhao");
        PersonBean nonOwnerProxy = ProxyFactory.getNonOwnerProxy(zhao);
        System.out.println("Name is" + nonOwnerProxy.getName());
        nonOwnerProxy.setHotOrNotRating(90);
        try {
            nonOwnerProxy.setInterests("basketball");
        } catch (Exception e) {
            System.out.println("不能为别人设置兴趣爱好");
        }
        System.out.println(zhao);
        
    }
}
