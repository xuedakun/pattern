package cn.com.pattern.strategy.simple;

public class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}

	/**
	 * 策略方法
	 */
	public void contextInterface() {

		strategy.strategyInterface();
	}

	public static void main(String[] args) {
		Context context = new Context(new ConcreteStrategyA());
		context.contextInterface();
		context = new Context(new ConcreteStrategyB());
		context.contextInterface();
		context = new Context(new ConcreteStrategyC());
		context.contextInterface();
		/**
		 * 根据不同具体策略角色 获取不同的结果
		 */
	}
}
