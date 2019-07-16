package cn.com.thread;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallableTask implements Callable<Integer>
{
    @Override
    public Integer call()
        throws Exception
    {
        System.out.println("callable do somothing");
        Thread.sleep(5000);
        return new Random().nextInt(100);
    }
}
