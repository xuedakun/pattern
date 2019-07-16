package cn.com.pattern.simpleFactory;

public interface Login {
	// 登录验证
	public boolean verify(String name, String password);
}
