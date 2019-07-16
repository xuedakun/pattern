package cn.com.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author xuekun
 * @create 2018-04-16 15:17
 **/
public class SimpleDaemons implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + ":" + this);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread() + "sleep():Interrupted");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SimpleDaemons());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("all daemon start");
        try {
            TimeUnit.MILLISECONDS.sleep(340);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
