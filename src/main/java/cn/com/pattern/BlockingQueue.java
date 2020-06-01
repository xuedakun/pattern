package cn.com.pattern;

import java.util.LinkedList;

/**
 * 使用linkedList实现阻塞队列
 * @author xuekun
 * @create 2020-03-20 10:26
 **/
public class BlockingQueue {

    private final LinkedList list=new LinkedList();
    private  int limit=10;

    public BlockingQueue(int limit)  {

        this.limit=limit;
    }
    public synchronized void enqueue(Object item)throws InterruptedException{
        while (list.size()==limit){
            wait();
        }
        if (list.size()==0){
            notifyAll();
        }
        list.add(item);
    }
    public synchronized Object dequeue()throws InterruptedException{
        while (list.size()==0){
            wait();
        }
        if (list.size()==limit){
            notifyAll();
        }
       return list.remove(0);
    }
}
