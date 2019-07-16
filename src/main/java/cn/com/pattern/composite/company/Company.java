package cn.com.pattern.composite.company;

/**
 * 文件名称：design.composite.Company.java 创建人：Fei Wong 创建时间： 2012-06-26
 * 电子邮箱：feiwong8@126.com
 * 
 */
public abstract class Company {
	private String name;

	public Company(String name) {
		this.name = name;
	}

	public Company() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected abstract void add(Company company);

	protected abstract void romove(Company company);

	protected abstract void display(int depth);
}