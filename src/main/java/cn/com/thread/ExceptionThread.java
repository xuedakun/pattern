package cn.com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuekun
 * @create 2018-04-17 11:13
 **/
public class ExceptionThread implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            ExceptionThread exceptionThread = new ExceptionThread();
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(exceptionThread);//线程池使用 execute 执行无返回值的任务
            executorService.shutdown();
        } catch (Exception e) {
            System.out.println("Exception has  been  handled!");
        }


    }
}
