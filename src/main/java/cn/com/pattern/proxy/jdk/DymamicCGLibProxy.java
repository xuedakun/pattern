package cn.com.pattern.proxy.jdk;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xuekun
 * @create 2019-11-25 11:58
 **/
public class DymamicCGLibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始CGLib动态代理");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("结束CGLib动态代理");
        return object;
    }
}
