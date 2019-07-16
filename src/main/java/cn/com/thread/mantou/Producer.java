package cn.com.thread.mantou;

class Producer implements Runnable { //生产者
	SyncStack ss = null;
	
	Producer(SyncStack ss) {
		this.ss = ss;
	}
	
	public void run() {
		for(int i=0; i<20; i++) { //一共要生成20个
			ManTou wt = new ManTou(i);
			ss.push(wt);
			System.out.println("生产了：" + wt);
			try { //生成一个睡1秒，便于观察
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
