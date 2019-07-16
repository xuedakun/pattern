package cn.com.code151;
/**
 * 
 * add in 2017年2月7日 下午4:08:06 
 * @author xuekun
 *
 */
public class Consumer {
	public static void main(String[] args) {
	  Person person=(Person) SerializationUtils.readObject();
	  System.out.println(person.name);
	}  
}
