package cn.com.pattern.proxy.jdk;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;
import java.security.spec.ECField;

/**
 * @author xuekun
 * @create 2019-11-25 13:51
 **/
public class CGLibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        IUserDao userDao = new UserDao();
//        enhancer.setCallback(new DymamicCGLibProxy());
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                System.out.println("开始CGLib动态代理");
//                Object object2 = methodProxy.invokeSuper(o, objects);
//                Object object = method.invoke(userDao, objects);
//                System.out.println("结束CGLib动态代理");
//                return object;
//            }
//        });

  /*      enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "fixed............";
            }
        });*/
        enhancer.setCallback(NoOp.INSTANCE);
        enhancer.setClassLoader(userDao.getClass().getClassLoader());
        UserDao ud = (UserDao) enhancer.create();
        ud.save();
        System.out.println(ud);
//        ud.delete();
    }
}
