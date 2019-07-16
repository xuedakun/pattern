package cn.com.pattern.chainOfResponsibility;

public class ConcreteHandler extends Handler {
	/**
	 * 处理方法，调用此方法处理请求
	 */
	@Override
	public void handleRequest() {
		/**
		 * 判断是否有后继的责任对象 如果有，就转发请求给后继的责任对象 如果没有，则处理请求
		 */
		if (getSuccessor() != null) {
			System.out.println("放过请求");
			getSuccessor().handleRequest();
		} else {
			System.out.print(this.getClass().getSimpleName() + ":");
			System.out.println("处理请求");
		}
	}

	@Override
	public String handleFeeRequest(String user, double fee) {
		// TODO Auto-generated method stub
		return null;
	}

}
