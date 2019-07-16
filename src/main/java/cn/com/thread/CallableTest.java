package cn.com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest
{
    public static void main(String[] args) throws Exception
    {
        Callable<Integer> callable = new MyCallableTask();
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        Thread thread = new Thread(future);
        thread.start();
        Thread.sleep(100);
        //尝试取消对此任务的执行
        future.cancel(true);
        //判断是否在任务正常完成前取消
        System.out.println("future is cancel:" + future.isCancelled());
        if(!future.isCancelled())
        {
            System.out.println("future is cancelled");
        }
        //判断任务是否已完成
        System.out.println("future is done:" + future.isDone());
        if(!future.isDone())
        {
            System.out.println("future get=" + future.get());
        }
        else
        {
            //任务已完成
            System.out.println("task is done");
        }
    }
}
