package cn.com.pattern.mediator;

/**
 * 调停者
 * 
 * @author xuekun
 *
 */
public interface Mediator {
	/**
	 *   
     * 同事对象在自身改变的时候来通知调停者方法
     * 让调停者去负责相应的与其他同事对象的交互
     *
	 * xuekun add in 2016年10月8日 上午11:50:02
	 * @param cdDriver
	 */
	public void changed(Colleague colleague);

}
