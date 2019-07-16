package cn.com.pattern.simpleFactory;

public class PasswordLogin implements Login {

	@Override
	public boolean verify(String name, String password) {
		return true;
	}

}
