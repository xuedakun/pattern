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
		System.out.println(Thread.currentThread().getName() + " �߳����п�ʼ!");
		for (int i = 0; i < 5; i++) {
			System.out.println("���߳�" + a + "���� : " + i);
			try {
				sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " �߳����н���!");
	}
}

public class MyThreadTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "���߳����п�ʼ!");
		MyThread mTh1 = new MyThread("A");
		MyThread mTh2 = new MyThread("B");
		mTh1.start();
		mTh2.start();
		try {
			mTh1.join();
			/**
			 * join��Thread���һ�������������̺߳�ֱ�ӵ��ã���join()�������ǣ����ȴ����߳���ֹ����������Ҫ���ľ��Ǹ��߳���ָ�����̵߳ȴ����̵߳���ֹ��Ҳ���������̵߳�����join()��������Ĵ��룬ֻ�еȵ����߳̽����˲���ִ�С�
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
		System.out.println(Thread.currentThread().getName() + "���߳����н���!");

	}

}
