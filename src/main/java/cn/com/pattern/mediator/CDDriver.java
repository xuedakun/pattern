package cn.com.pattern.mediator;

/***
 * 光驱类
 * 
 * @author xuekun
 *
 */
public class CDDriver extends Colleague {
	// 光驱读取出来的数据
	private String data = "";

	/**
	 * 构造函数
	 */
	public CDDriver(Mediator mediator) {
		super(mediator);
	}

	/**
	 * 获取光盘读取的数据 xuekun add in 2016年10月8日 上午11:47:39
	 * 
	 * @return
	 */
	public String getData() {
		return data;
	}

	/**
	 * 读取光盘 xuekun add in 2016年10月8日 上午11:48:50
	 */
	public void readCD() {
		// 逗号前是视频显示的数据，逗号后是声音
		this.data = "One Piece,海贼王我当定了";
		// 通知主板，自己的状态发生了改变
		getMediator().changed(this);
	}
}
