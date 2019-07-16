package cn.com.pattern.newPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xuekun
 * @create 2018-04-13 15:18
 **/
public class ProxyJdkFactory {

    private Object target;

    public ProxyJdkFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("......before.........");
                Object returnValue = method.invoke(target, args);
                System.out.println("......after..........");
                return returnValue;
            }
        });
    }
}
