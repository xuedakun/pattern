package cn.com.pattern.facade;

/**
 * 使用外观模式，只需要少量代码，就能提供典型的、无修饰用法的类库中的类。一个外观就是一个类，它包含的功能介于工具包与完整的应用程序之间，
 * 为工具包或子系统的类提供了简单的用法
 * 
 * @author xuekun
 *
 */
public class Computer {
	private CPU cpu = new CPU();
	private Disk disk = new Disk();
	private Memory memory = new Memory();

	// 声明对象
	public void startup() { // 调用对象的方法
		cpu.startup();
		disk.startup();
		memory.startup();
	}

	public void shutdown() {// 调用对象的方法
		cpu.shutdown();
		disk.shutdown();
		memory.shutdown();
	}
}
