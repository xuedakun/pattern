package cn.com.pattern.composite.company;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件名称：design.singleton.CommandInvoker.java 创建人：Fei Wong 创建时间： 2012-06-26
 * 电子邮箱：feiwong8@126.com
 * 
 */
public class ConcreteCompany extends Company {
	private List<Company> cList;

	public ConcreteCompany() {
		cList = new ArrayList<Company>();
	}

	public ConcreteCompany(String name) {
		super(name);
		cList = new ArrayList<Company>();
	}

	@Override
	protected void add(Company company) {
		cList.add(company);
	}

	@Override
	protected void display(int depth) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < depth; i++) {
			sb.append("-");
		}
		System.out.println(new String(sb) + this.getName());
		for (Company c : cList) {
			c.display(depth + 2);
		}
	}

	@Override
	protected void romove(Company company) {
		cList.remove(company);
	}
}
