package cn.com.pattern.newPattern.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.invoke.MethodHandleInfo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xuekun
 * @create 2018-04-13 15:18
 **/
public class ProxyCglibFactory implements MethodInterceptor {

    private Object target;

    public ProxyCglibFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("1......before.........");
        Object returnValue = method.invoke(target, objects);
        System.out.println("1......after..........");
        return returnValue;
    }
}
