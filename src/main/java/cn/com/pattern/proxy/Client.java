package cn.com.pattern.proxy;

public class Client {
	public static void main(String[] args) {
		AbstractObject obj = new ProxyObject();
		obj.operation();
	}
}
