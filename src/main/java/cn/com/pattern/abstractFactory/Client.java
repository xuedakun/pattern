package cn.com.pattern.abstractFactory;

public class Client {
	public static void main(String[] args) {
		ComputerEngineer cf2 = new ComputerEngineer();
		System.out.println("符合规定的装机需求：");
		cf2.makeComputer(1, 1);
		System.err.println("不符合规定的装机需求：");
		cf2.makeComputer(1, 2);
		System.err.println("----------------使用抽象工厂----------------");
		// 创建装机工程师对象
		ComputerEngineer cf = new ComputerEngineer();
		// 客户选择并创建需要使用的产品对象
		AbstractFactory af = new IntelFactory();
		// 告诉装机工程师自己选择的产品，让装机工程师组装电脑
		cf.makeComputer(af);
	}
}
