package cn.com.pattern.chainOfResponsibility;

public class Client {
	public static void main(String[] args) {

		// 组装责任链
		Handler handler1 = new ConcreteHandler();
		Handler handler2 = new ConcreteHandler();
		Handler handler3 = new ConcreteHandler();
		Handler handler4 = new ConcreteHandler();
		Handler handler5 = new ConcreteHandler();
		Handler handler6 = new ConcreteHandler();
		Handler handler7 = new ConcreteHandler();
		handler1.setSuccessor(handler2);
		handler2.setSuccessor(handler3);
		handler3.setSuccessor(handler4);
		handler4.setSuccessor(handler5);
		handler5.setSuccessor(handler6);
		handler6.setSuccessor(handler7);
		// 提交请求
		handler1.handleRequest();

		System.out.println("#######################################");
		// 先要组装责任链
		Handler h1 = new GeneralManager();
		Handler h2 = new DeptManager();
		Handler h3 = new ProjectManager();
		h3.setSuccessor(h2);
		h2.setSuccessor(h1);

		// 开始测试
		String test1 = h3.handleFeeRequest("张三", 300);
		System.out.println("test1 = " + test1);
		String test2 = h3.handleFeeRequest("李四", 300);
		System.out.println("test2 = " + test2);
		System.out.println("---------------------------------------");

		String test3 = h3.handleFeeRequest("张三", 700);
		System.out.println("test3 = " + test3);
		String test4 = h3.handleFeeRequest("李四", 700);
		System.out.println("test4 = " + test4);
		System.out.println("---------------------------------------");

		String test5 = h3.handleFeeRequest("张三", 1500);
		System.out.println("test5 = " + test5);
		String test6 = h3.handleFeeRequest("李四", 1500);
		System.out.println("test6 = " + test6);
	}

}