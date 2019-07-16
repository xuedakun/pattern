package cn.com.pattern.strategy.member;

public class AdvancedMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("高级会员20%的折扣");
		return booksPrice*0.8;
	}

}
