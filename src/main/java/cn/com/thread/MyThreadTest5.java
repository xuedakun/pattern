package cn.com.thread;

class MyThread5 implements Runnable {
	private String name;
	private byte[] prev;
	private byte[] self;

	public MyThread5(String name, byte[] prev, byte[] self) {
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
				count--;
				System.out.println(name);
				try {
					prev.wait(1000);
					//this.notify();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
		}

	}
}

public class MyThreadTest5 {
	public static void main(String[] args) {
		byte[] a = new byte[0];
		byte[] b = new byte[0];
		byte[] c = new byte[0];
		MyThread5 pa = new MyThread5("A", c, a);
		MyThread5 pb = new MyThread5("B", c, a);

		new Thread(pa).start();
		new Thread(pb).start();
	}
}
