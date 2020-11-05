package designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自己的调用处理器
 *
 * @author wangdongxing
 * @since 2018-12-03 20:22
 */
public class OwnerInvocationHandler implements InvocationHandler {

    private PersonBean personBean;

    public OwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        String methodName = method.getName();
        try {
            if (methodName.startsWith("get")) {
                return method.invoke(personBean, args);
            } else if (methodName.startsWith("setHotOrNotRating")) {
                throw new IllegalAccessException();
            } else if (methodName.startsWith("set")) {
                return method.invoke(personBean, args);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
