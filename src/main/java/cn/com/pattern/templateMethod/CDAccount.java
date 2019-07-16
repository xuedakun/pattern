package cn.com.pattern.templateMethod;

public class CDAccount extends Account {

	@Override
	protected String doCalculateAccountType() {
		return "CDAccount";
	}

	@Override
	protected double doCalculateInterestRate() {
		return 0.2;
	}

}
