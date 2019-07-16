package cn.com.pattern.strategy.member;

public class IntermediateMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("中级会员10%的折扣");
		return booksPrice*0.9;
	}

}
