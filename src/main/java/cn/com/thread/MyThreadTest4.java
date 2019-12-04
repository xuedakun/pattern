package cn.com.thread;

class MyThread4 implements Runnable {
	private String name;
	private byte[] prev;
	private byte[] self;

	public MyThread4(String name, byte[] prev, byte[] self) {
		super();
		this.name = name;
		this.prev = prev;
		this.self = self;
	}

	@Override
	public void run() {
		int count = 10;
		while (count > 0) {
			synchronized (prev) { 
				synchronized (self) {
					System.out.println(name+count);
					count--;
					self.notify();
				}
				try {
					System.out.println(name+":"+(count+1)+" a");
					prev.wait();
					System.out.println(name+":"+(count+1)+" b");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}

public class MyThreadTest4 {
	public static void main(String[] args) {
		byte[] a = new byte[0];
		byte[] b = new byte[0];
		byte[] c = new byte[0];
		MyThread4 pa = new MyThread4("A", c, a);
		MyThread4 pb = new MyThread4("B", a, b);
		MyThread4 pc = new MyThread4("C", b, c);

		new Thread(pa).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // 确保按顺序A、B、C执行
		new Thread(pb).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(pc).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}