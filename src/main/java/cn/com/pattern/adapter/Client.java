package cn.com.pattern.adapter;

//客户端，也就是问题中的键盘  
public class Client {
	public static void main(String[] args) {
		Target target = new Adapter();
		// 键盘只能使用圆形的USB接口
		target.provideCircleUsb();
	}

}