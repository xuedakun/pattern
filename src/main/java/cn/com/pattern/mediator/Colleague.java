package cn.com.pattern.mediator;

/**
 * 抽象同事类
 * 
 * @author xuekun
 *
 */
public abstract class Colleague {
	// 持有一个调停者对象
	private Mediator mediator;

	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}

	/**
	 * 获取当前同事类对应的调停者对象
	 * xuekun add in 2016年10月8日 上午11:44:45
	 * @return
	 */
	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

}
