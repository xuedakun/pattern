package cn.com.pattern.composite.company;

/**
 * 文件名称：design.composite.FinanceDepartment.java 创建人：Fei Wong 创建时间： 2012-06-26
 * 电子邮箱：feiwong8@126.com
 */
public class FinanceDepartment extends Company {

	public FinanceDepartment() {

	}

	public FinanceDepartment(String name) {
		super(name);
	}

	@Override
	protected void add(Company company) {

	}

	@Override
	protected void display(int depth) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < depth; i++) {
			sb.append("-");
		}
		System.out.println(new String(sb) + this.getName());
	}

	@Override
	protected void romove(Company company) {

	}

}
