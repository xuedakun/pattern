package cn.com.thread.mantou;

class Consumer implements Runnable {
	SyncStack ss = null;
	
	Consumer(SyncStack ss) {
		this.ss = ss;
	}
	public void run() {
		for(int i=0; i<20; i++) { //一共要吃20个
			ManTou wt = ss.pop();
			System.out.println("消费了：" + wt);
		}
	}
}
