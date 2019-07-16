package cn.com.pattern.facade;

public class User {
	public static void main(String args[]) {
		Computer computer = new Computer();
		computer.startup(); // 调用
		computer.shutdown();
	}
}
