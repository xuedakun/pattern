package cn.com.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuekun
 * @create 2020-05-25 15:20
 **/
public class WaitNotifyModel implements Model {

    private final Object BUFFER_LOCK = new Object();
    private final Queue<Task> queue = new LinkedList<>();
    private final int capacity;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public WaitNotifyModel(int capacity) {
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
            synchronized (BUFFER_LOCK) {
                while (queue.size() == capacity) {
                    BUFFER_LOCK.wait();
                }
                Task task = new Task(increTaskNo.getAndIncrement());
                System.out.println(Thread.currentThread().getName() + " produce: " + task.toString());
                queue.offer(task);
                BUFFER_LOCK.notifyAll();
            }
        }
    }

    private class RunnableConsumer extends AbstractConsumer {

        @Override
        public void consume() throws InterruptedException {
            synchronized (BUFFER_LOCK) {
                while (queue.size() == 0) {
                    BUFFER_LOCK.wait();
                }
                Task task = queue.poll();
                if (task != null) {
                    // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                    Thread.sleep(500 + (long) (Math.random() * 500));
                    System.out.println(Thread.currentThread().getName() + " consume: " + task.no);
                    BUFFER_LOCK.notifyAll();
                } else {
                    System.out.println(Thread.currentThread().getName() + " 被其他线程消费！");
                }
            }
        }
    }

    public static void main(String[] args) {
        Model model = new WaitNotifyModel(3);
        for (int i = 0; i < 20; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
        for (int i = 0; i < 20; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
    }
}
