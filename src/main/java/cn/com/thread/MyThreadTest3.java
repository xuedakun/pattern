package cn.com.thread;

class MyThread3 extends Thread {
	public MyThread3(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			System.out.println("" + this.getName() + "-----" + i);
			// ��iΪ30ʱ�����߳̾ͻ��CPUʱ���õ��������������Լ����߳�ִ�У�Ҳ����˭������˭ִ�У�
			if (i == 30) {
				this.yield();
			}
		}

	}
}

public class MyThreadTest3 {
	public static void main(String[] args) {

		MyThread3 yt1 = new MyThread3("����");
		MyThread3 yt2 = new MyThread3("����");
		yt1.setPriority(Thread.MAX_PRIORITY);//1��10 ֵԽ�� ���ȼ�Խ��
		yt2.setPriority(Thread.MIN_PRIORITY);
		yt1.start();
		yt2.start();
	}
}