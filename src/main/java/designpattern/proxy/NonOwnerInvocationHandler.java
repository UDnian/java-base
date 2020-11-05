package designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 其他人的调用处理器
 *
 * @author wangdongxing
 * @since 2018-12-03 20:29
 */
public class NonOwnerInvocationHandler implements InvocationHandler {

    private PersonBean personBean;

    public NonOwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        String methodName = method.getName();
        try {
            if (methodName.startsWith("set")) {
                if (!methodName.startsWith("setHotOrNotRating")) {
                    throw new IllegalAccessException();
                }
            }
            return method.invoke(personBean, args);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
