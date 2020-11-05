package designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理类工厂
 *
 * @author wangdongxing
 * @since 2020/9/27 6:23 下午
 */
public class ProxyFactory {
    
    public static PersonBean getOwnerProxy(PersonBean personBean) {
        ClassLoader classLoader = personBean.getClass().getClassLoader();
        Class<?>[] interfaces = personBean.getClass().getInterfaces();
        InvocationHandler ownerInvocationHandler = new OwnerInvocationHandler(personBean);
        return (PersonBean) Proxy.newProxyInstance(classLoader, interfaces, ownerInvocationHandler);
    }
    
    public static PersonBean getNonOwnerProxy(PersonBean personBean) {
        ClassLoader classLoader = personBean.getClass().getClassLoader();
        Class<?>[] interfaces = personBean.getClass().getInterfaces();
        NonOwnerInvocationHandler nonOwnerInvocationHandler = new NonOwnerInvocationHandler(personBean);
        return (PersonBean) Proxy.newProxyInstance(classLoader, interfaces, nonOwnerInvocationHandler);
    }
    
}
