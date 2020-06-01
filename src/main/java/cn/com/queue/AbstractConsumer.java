package cn.com.queue;

/**
 * @author xuekun
 * @create 2020-05-25 14:43
 **/
public abstract class AbstractConsumer implements Consumer, Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
