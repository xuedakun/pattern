package cn.com.thread;

import cn.com.thread.lock.EvenChecker;
import cn.com.thread.lock.IntGenerator;

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    public int next() {
        ++currentEvenValue; // Danger   point here!
        ++currentEvenValue;
        return currentEvenValue;


    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
