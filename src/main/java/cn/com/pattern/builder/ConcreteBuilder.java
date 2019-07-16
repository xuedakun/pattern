package cn.com.pattern.builder;

public class ConcreteBuilder implements Builder {
	private Product product = new Product();

	@Override
	public void buildPart1() {
		// 构建产品的第一个零件
		product.setPart1("编号：9527");

	}

	@Override
	public void buildPart2() {
		// 构建产品的第一个零件
		product.setPart2("名称：XXX");	

	}

	@Override
	public Product retrieveResult() {
		return product;
	}

}
