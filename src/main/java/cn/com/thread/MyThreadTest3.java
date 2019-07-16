package cn.com.thread;

class MyThread3 extends Thread {
	public MyThread3(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			System.out.println("" + this.getName() + "-----" + i);
			// 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
			if (i == 30) {
				this.yield();
			}
		}

	}
}

public class MyThreadTest3 {
	public static void main(String[] args) {

		MyThread3 yt1 = new MyThread3("张三");
		MyThread3 yt2 = new MyThread3("李四");
		yt1.setPriority(Thread.MAX_PRIORITY);//1到10 值越大 优先级越高
		yt2.setPriority(Thread.MIN_PRIORITY);
		yt1.start();
		yt2.start();
	}
}