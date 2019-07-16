package cn.com.code151;

public class Producer {
	public static void main(String[] args) {
		Person p = new Person();
		SerializationUtils.writeObject(p);
	}
}
