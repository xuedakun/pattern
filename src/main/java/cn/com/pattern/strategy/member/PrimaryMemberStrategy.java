package cn.com.pattern.strategy.member;

public class PrimaryMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("初级会员没有折扣！");
		return booksPrice;
	}

}
