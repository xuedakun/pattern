package cn.com.pattern.adapter;

/**
 * 在这种适配器模式中，适配器容纳一个它包裹的类的实例。在这种情况下，
 * 适配器调用被包裹对象的物理实体。当你需要适配的一组方法并非定义在接口中时，就可以创建一个对象适配器，采用对象方式实现：
 * 
 * @author xuekun
 *
 */
public class AdapterObject implements Target {
	private Adaptee adptee;

	public AdapterObject(Adaptee adptee) {
		this.adptee = adptee;
	}

	@Override
	// 转换器将圆形的接口转换为方形接口
	public void provideCircleUsb() {
		adptee.provideSquareUsb();
	}
}