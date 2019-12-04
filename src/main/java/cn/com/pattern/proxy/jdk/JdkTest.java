package cn.com.pattern.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author xuekun
 * @create 2019-11-25 11:49
 **/
public class JdkTest {
    public static void main(String[] args) {
        IUserDao userDao = new UserDao();
        // DynamicJdkProxy dynamicJdkProxy = new DynamicJdkProxy(userDao);
        //IUserDao proxy = (IUserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), dynamicJdkProxy);
        IUserDao proxy = getProxy(userDao);
                /* (IUserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                if ("find".equals(method.getName())) {
                    result = method.invoke(userDao, args);
                } else {
                    System.out.println("开始JDK代理");
                    result = method.invoke(userDao, args);
                    System.out.println("结束JDK代理");
                }

                return result;
            }
        });*/
        proxy.save();
        System.out.println("----------------");
        proxy.delete();
    }

    public static IUserDao getProxy(IUserDao userDao) {

//        IUserDao proxy = (IUserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                Object result = null;
//                if ("find".equals(method.getName())) {
//                    result = method.invoke(userDao, args);
//                } else {
//                    System.out.println("开始jdk代理");
//                    result = method.invoke(userDao, args);
//                    System.out.println("结束jdk代理");
//
//                }
//                return result;
//            }
//        });
        //jdk8 lambda
        IUserDao proxy = (IUserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), (o, method, args) -> {
            Object result = null;
            if ("find".equals(method.getName())) {
                result = method.invoke(userDao, args);
            } else {
                System.out.println("开始jdk代理");
                result = method.invoke(userDao, args);
                System.out.println("结束jdk代理");

            }
            return result;
        });
        return proxy;
    }
}
