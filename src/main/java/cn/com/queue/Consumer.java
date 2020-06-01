package cn.com.queue;

/**
 * 消费者
 *
 * @author xuekun
 * @create 2020-05-25 14:40
 **/
public interface Consumer {
    void consume() throws InterruptedException;
}
