package cn.com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuekun
 * @create 2018-04-16 14:36
 **/
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ":" + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 10000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exe.submit(new SimplePriorities(Thread.MIN_PRIORITY));
            exe.submit(new SimplePriorities(Thread.MAX_PRIORITY));
        }
        exe.shutdown();
    }
}
