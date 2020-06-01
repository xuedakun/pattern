package cn.com.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuekun
 * @create 2020-05-25 14:50
 **/
public class BlockingQueueModel implements Model {

    private final BlockingQueue<Task> queue;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public BlockingQueueModel(int capacity) {
        queue = new LinkedBlockingQueue<>(capacity);
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new RunnableConsumer();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new RunnableProducer();
    }

    private class RunnableConsumer extends AbstractConsumer {

        @Override
        public void consume() throws InterruptedException {
            Task task = queue.take();
            System.out.println("consume: " + task.toString());
            // 固定时间范围的消费，模拟相对稳定的服务器处理过程
            Thread.sleep(500 + (long) (Math.random() * 500));
        }
    }

    private class RunnableProducer extends AbstractProducer {
        @Override
        public void produce() throws InterruptedException {
            //不定期生产
            Thread.sleep((long) Math.random() * 1000);
            Task task = new Task(increTaskNo.getAndIncrement());
            System.out.println("produce: " + task.no);
            queue.put(task);
        }
    }


    public static void main(String[] args) {
        BlockingQueueModel model = new BlockingQueueModel(3);
        for (int i = 0; i <2 ; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
        for (int i = 0; i <2 ; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }

    }


}
