package cn.com.thread;

/**
 * @author xuekun
 * @create 2019-10-24 10:23
 **/
public class VolatileTest implements Runnable {

    private static volatile  int count = 0;


    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        Thread t1 = new Thread(volatileTest,"t1") ;
        Thread t2 = new Thread(volatileTest,"t2") ;
        t1.start();
        t2.start();
        for (int i=0;i<100000 ;i++){
            count ++ ;
        }
        System.out.println("最终Count="+count);
    }

    @Override
    public void run() {
        for (int i=0;i<100000 ;i++){
            count ++ ;
            //count.incrementAndGet() ;
        }
    }
}
