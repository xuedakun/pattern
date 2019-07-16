package cn.com.thread;

import cn.com.thread.lock.EvenChecker;
import cn.com.thread.lock.IntGenerator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    public  int next() {
        lock.lock();
        try {
            ++currentEvenValue; // Danger   point here!
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }


    }

    public static void main(String[] args) {
        EvenChecker.test(new LockEvenGenerator());
    }
}
