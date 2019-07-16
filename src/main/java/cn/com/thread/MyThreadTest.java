package cn.com.thread;

class MyThread extends Thread {
	private String a;

	public MyThread(String a) {
		super();
		this.a = a;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
		for (int i = 0; i < 5; i++) {
			System.out.println("子线程" + a + "运行 : " + i);
			try {
				sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
	}
}

public class MyThreadTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
		MyThread mTh1 = new MyThread("A");
		MyThread mTh2 = new MyThread("B");
		mTh1.start();
		mTh2.start();
		try {
			mTh1.join();
			/**
			 * join是Thread类的一个方法，启动线程后直接调用，即join()的作用是：“等待该线程终止”，这里需要理解的就是该线程是指的主线程等待子线程的终止。也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。
			 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mTh2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "主线程运行结束!");

	}

}
