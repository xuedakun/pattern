package cn.com.pattern;

import java.util.concurrent.locks.StampedLock;

/**
 * @author xuekun
 * @create 2020-03-24 10:15
 **/
public class StampedLockTest {
    private final StampedLock stampedLock = new StampedLock();

    public void mutate() {
        long stamp = stampedLock.writeLock();
        try {
            write();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public Object access() {
        long stamp = stampedLock.tryOptimisticRead();
        Object data = read();
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                data = read();
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        return data;
    }

    private Object read() {
        return "";
    }

    private void write() {
    }
}
