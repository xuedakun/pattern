package cn.com.thread;

/**
 * @functon ���߳�ѧϰ �̳�runnable����Դ�ܹ���
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
			System.out.println(Thread.currentThread().getName() + "����  count= " + count--);
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
		Thread t1 = new Thread(mTh1, "�߳�1");
		Thread t2 = new Thread(mTh1, "�߳�2");

		/**
		 * 1�����ʺ϶����ͬ�ĳ��������߳�ȥ����ͬһ����Դ
		 * 
		 * 2�������Ա���java�еĵ��̳е�����
		 * 
		 * 3�������ӳ���Ľ�׳�ԣ�������Ա�����̹߳�����������ݶ���
		 */
		t1.start();
		t2.start();
	}

}
