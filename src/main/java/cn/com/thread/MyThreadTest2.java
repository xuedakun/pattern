package cn.com.thread;

/**
 * @functon 多线程学习 继承runnable，资源能共享
 * @author xk
 * @time 2015.3.9
 */
class MyThread2 implements Runnable {
	private String a;
	private int count = 10;

	public MyThread2(String a) {
		super();
		this.a = a;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "运行  count= " + count--);
			try {
				Thread.sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class MyThreadTest2 {

	public static void main(String[] args) {
		MyThread2 mTh1 = new MyThread2("A");
		//MyThread2 mTh2 = new MyThread2("B");
		Thread t1 = new Thread(mTh1, "线程1");
		Thread t2 = new Thread(mTh1, "线程2");

		/**
		 * 1）：适合多个相同的程序代码的线程去处理同一个资源
		 * 
		 * 2）：可以避免java中的单继承的限制
		 * 
		 * 3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
		 */
		t1.start();
		t2.start();
	}

}
