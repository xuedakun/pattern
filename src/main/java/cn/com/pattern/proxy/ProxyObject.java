package cn.com.pattern.proxy;

public class ProxyObject extends AbstractObject {
	private RealObject realObject = new RealObject();

	@Override
	public void operation() {
		System.out.println("before");
		realObject.operation();
		System.out.println("after");

	}

}
