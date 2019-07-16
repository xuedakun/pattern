package cn.com.pattern.singleton;

/**
 * @author xuekun
 * @create 2019-07-15 16:58
 **/
public class Singleton {
    private Singleton() {
    }

    private static class HolderClass {
        private static final Singleton instance = new Singleton();
    }
    public static Singleton getInstance() {
        return HolderClass.instance;
    }

}
