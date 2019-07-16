package cn.com.thread;

import cn.com.thread.lock.EvenChecker;
import cn.com.thread.lock.IntGenerator;

public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    public synchronized int next() {
        ++currentEvenValue; // Danger   point here!
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;


    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
