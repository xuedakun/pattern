package cn.com.thread.lock;

import java.util.concurrent.*;

public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        generator = g;
        id = ident;
    }

    @Override
    public String toString() {
        return "EvenChecker{" +
                "id=" + id +
                '}';
    }

    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(this.toString()+":"+val + " not even!");
                generator.cancel(); // Cancels all EvenCheckers
            }else{
                //System.out.println(this.toString()+":"+val + "  even!");
            }
        }
    }

    // Test any  type of IntGenerator:
    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
//        exec.shutdown();
    }

    // Default value for  count:
    public static void test(IntGenerator gp) {
        test(gp, 10);

    }
} ///:~
