package cn.com.thread.mantou;

public class ProducerConsumer {
	public static void main(String[] args) {
		SyncStack ss = new SyncStack(); //定义篮子
		Producer p = new Producer(ss);  //定义生产者
		Consumer c = new Consumer(ss);  //定义消费者
		new Thread(p).start();
		new Thread(c).start();
	}
}
