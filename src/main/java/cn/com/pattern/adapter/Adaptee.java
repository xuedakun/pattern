package cn.com.pattern.adapter;

//源角色，这里是指提供方形的usb接口  
public class Adaptee {
	public void provideSquareUsb() {
		System.out.println("我提供方形的USB接口");
	}
}