package cn.com.pattern.templateMethod;
/**
 * 
 * add in 2016年12月8日 下午4:00:19 
 * @author xuekun
 *
 */
public class MoneyMarketAccount extends Account {

	@Override
	protected String doCalculateAccountType() {
		return "Money Market";
	}

	@Override
	protected double doCalculateInterestRate() {
		return 0.45;
	}

}
