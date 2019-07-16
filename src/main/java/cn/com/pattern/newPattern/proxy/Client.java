package cn.com.pattern.newPattern.proxy;

/**
 * 静态代理
 */
public class Client {

    public static void main(String[] args) {
        ITargetDao dao = new TargetDao();
//        UserDaoProxy proxy = new TargetProxy(dao);
//        proxy.save();
//        proxy.find();
//        proxy.update();
        ITargetDao proxy= (ITargetDao) new ProxyCglibFactory(dao).getProxyInstance();
        ITargetDao proxy2= (ITargetDao) new ProxyJdkFactory(dao).getProxyInstance();
        proxy.save();
        proxy.find();
        proxy.update();
        proxy2.save();
        proxy2.find();
        proxy2.update();

    }


}
