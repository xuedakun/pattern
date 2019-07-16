
package cn.com.pattern.adapter;
/**
 *         类适配器
        这种适配器模式下，适配器继承自已实现的类（一般多重继承）。
      具体来说，我们需要实现目标接口，并继承自现有类，来达到用户所期望的效果。具体实现如下：
 * @author xuekun
 *
 */
//适配角色，这里指老板买给我们的那个转换器  
public class Adapter extends Adaptee implements Target {
	@Override
	// 转换器将圆形的接口转换为方形接口
	public void provideCircleUsb() {
		this.provideSquareUsb();
	}
}