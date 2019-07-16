package cn.com.pattern.builder.autoMessage;

public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Builder builder = new WelcomeBuilder();
		Director director = new Director(builder);
		director.construct("toAddress@126.com", "fromAddress@126.com");
		System.err.println("-----------------------------------------");
		director=new Director(new GoodbyeBuilder());
		director.construct("toAddress@163.com", "fromAddress@163.com");
	}
}
