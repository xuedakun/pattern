package cn.com.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuekun
 * @create 2020-05-25 15:20
 **/
public class LockConditionModel1 implements Model {

    private final Lock BUFFER_LOCK = new ReentrantLock();
    private final Condition CONDITION = BUFFER_LOCK.newCondition();
    private final Queue<Task> queue = new LinkedList<>();
    private final int capacity;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public LockConditionModel1(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new RunnableConsumer();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new RunnableProducer();
    }

    private class RunnableProducer extends AbstractProducer {

        @Override
        public void produce() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求
            Thread.sleep((long) (Math.random() * 1000));
            BUFFER_LOCK.lockInterruptibly();
            try {
                while (queue.size() == capacity) {
                    CONDITION.await();
                }
                Task task = new Task(increTaskNo.getAndIncrement());
                System.out.println(Thread.currentThread().getName() + " produce: " + task.toString());
                queue.offer(task);
                CONDITION.signalAll();
            } finally {
                BUFFER_LOCK.unlock();
            }
        }
    }

    private class RunnableConsumer extends AbstractConsumer {

        @Override
        public void consume() throws InterruptedException {
            BUFFER_LOCK.lockInterruptibly();
            try {
                while (queue.size() == 0) {
                    CONDITION.await();
                }
                Task task = queue.poll();
                if (task != null) {
                    // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                    Thread.sleep(500 + (long) (Math.random() * 500));
                    System.out.println(Thread.currentThread().getName() + " consume: " + task.no);
                    CONDITION.signalAll();
                } else {
                    System.out.println(Thread.currentThread().getName() + " 被其他线程消费！");
                }
            } finally {
                BUFFER_LOCK.unlock();
            }
        }

    }

    public static void main(String[] args) {
        Model model = new LockConditionModel1(3);
        for (int i = 0; i < 20; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
        for (int i = 0; i < 20; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
    }
}
