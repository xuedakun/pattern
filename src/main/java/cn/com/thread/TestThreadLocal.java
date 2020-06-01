package cn.com.thread;

import java.util.Random;

public class TestThreadLocal {

    public static class MyRunnable1 implements Runnable {

        private ThreadLocal<Integer> threadlocal = new ThreadLocal<Integer>();

        @Override
        public void run() {
            threadlocal.set(new Random().nextInt(10));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " : " + threadlocal.get());
        }
    }

    public static void main(String[] args) {
        System.out.println("start");
        MyRunnable1 runnable = new MyRunnable1();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
