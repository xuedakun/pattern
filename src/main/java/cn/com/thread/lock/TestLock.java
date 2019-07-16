package cn.com.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuekun
 * @create 2018-05-14 15:20
 **/
public class TestLock {


    public static void main(String[] args) {
        Test test = new Test();
        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 20; i++) {
//
//        }
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                int a = test.setA();
//                int b = test.setA();

//                while (a % 2 == 0) {
//                    a = test.setA();
//                    System.out.println("#......." + Thread.currentThread().getName()+"a:"+a);
//                }

            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                int b = test.setA();
//                int b = test.setA();

//                while (b % 2 == 0) {
//                    b = test.setA();
//                    System.out.println("#......." + Thread.currentThread().getName()+"a:"+b);
//                }

            }
        });
    }
}

class Test {
    private int a = 0;
    private int b = 0;

    public synchronized int setA() {
        a++;
        a++;
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a 等待结束");
        return a;
    }

    public synchronized int setB() {
        b++;
        b++;
        return b;
    }
}
