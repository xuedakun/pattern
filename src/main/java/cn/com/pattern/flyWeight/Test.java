package cn.com.pattern.flyWeight;

public class Test {

	public static void main(String[] args) {

		String a = new String("abc");
		String b = new String("abc");
		System.out.println(a == b);

		/**
		 * ==比较的是对象的地址，也就是是否是同一个对象； equal比较的是对象的值。 1 2 3 4
		 */
		Integer r1 = new Integer(900);// 定义r1整型对象
		Integer r2 = new Integer(900);
		// 定义r2整型对象
		System.out.println(r1 == r2);// 返回false
		System.out.println(r1.equals(r2));// 返回true

	}
}
