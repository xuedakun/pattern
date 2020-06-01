package cn.com.queue;

/**
 * 不同的模型的消费，生产实现不同
 */
public interface Model {
    Runnable newRunnableConsumer();

    Runnable newRunnableProducer();
}
