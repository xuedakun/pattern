package cn.com.queue;

/**
 * 生产者
 *
 * @author xuekun
 * @create 2020-05-25 14:41
 **/
public interface Producer {
    void produce() throws InterruptedException;
}
