package cn.com.pattern.strategy.member;

public class Price {
	private MemberStrategy memberStrategy;
	
	
	public Price(MemberStrategy memberStrategy) {
		super();
		this.memberStrategy = memberStrategy;
	}


	public MemberStrategy getMemberStrategy() {
		return memberStrategy;
	}


	public void setMemberStrategy(MemberStrategy memberStrategy) {
		this.memberStrategy = memberStrategy;
	}


	public double quote(double booksPrice){
		return memberStrategy.calcPrice(booksPrice);
	}
}
