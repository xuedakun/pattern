package cn.com.pattern.mediator;

class fa {
	public void foo(int a, int... b) {
		System.out.println("fa");
	}
}

public class Client extends fa {
	@Override
	public void foo(int a, int[] b) {
		System.out.println("child");
	}

	public static void main(String[] args) {
		fa fa = new fa();
		fa.foo(1, 5);
		Client client = new Client();
		//client.foo(1, 5 });
	}
	/*
	 * public static void main(String[] args) { // 创建调停者——主板 MainBoard mediator
	 * = new MainBoard(); // 创建同事类 CDDriver cd = new CDDriver(mediator); CPU cpu
	 * = new CPU(mediator); VideoCard vc = new VideoCard(mediator); SoundCard sc
	 * = new SoundCard(mediator); // 让调停者知道所有同事 mediator.setCdDriver(cd);
	 * mediator.setCpu(cpu); mediator.setVideoCard(vc);
	 * mediator.setSoundCard(sc); // 开始看电影，把光盘放入光驱，光驱开始读盘 cd.readCD();
	 * 
	 * }
	 */

}
