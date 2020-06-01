package cn.com.queue;

/**
 * @author xuekun
 * @create 2020-05-25 14:46
 **/
public abstract class AbstractProducer implements Producer, Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
