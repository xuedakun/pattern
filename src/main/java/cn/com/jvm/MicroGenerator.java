package cn.com.jvm;

import javassist.ClassPool;

import java.util.List;

public class MicroGenerator {
    public static void main(String[] args) throws Exception {
        List<int[]> l = new java.util.ArrayList();
        for (int i = 10000; i < 100000; i++) {
            try {
                l.add(new int[100000000]);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    public static Class generate(String name) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        return pool.makeClass(name).toClass();
    }
}
