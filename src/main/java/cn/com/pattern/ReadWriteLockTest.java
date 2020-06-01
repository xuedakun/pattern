package cn.com.pattern;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xuekun
 * @create 2020-03-20 11:35
 **/
public class ReadWriteLockTest {
    public static void main(String[] args) {
        final TheData myData = new TheData();  //这是各线程的共享数据
        for (int i = 0; i < 3; i++) { //开启3个读线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        myData.read();
                    }
                }
            }).start();
        }
        for (int i = 0; i < 3; i++) { //开启3个写线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        myData.write(new Random().nextInt(10000));
                    }
                }
            }).start();
        }
    }
}

class TheData {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Object data = null;

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "is ready to read");
            Thread.sleep(new Random().nextInt(100));
            System.out.println(Thread.currentThread().getName() + "have read date" + data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }

    }

    public void write(Object data) {
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "is ready to write");
            Thread.sleep(new Random().nextInt(100));
            this.data = data;
            System.out.println(Thread.currentThread().getName() + "have write date" + data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

