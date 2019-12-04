package cn.com.pattern.proxy.jdk;

public class StaticTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        IUserDao udp = new UserDaoProxy(new UserDao());
        udp.save();
        System.out.println("-------------------");
        udp.delete();
    }

}
