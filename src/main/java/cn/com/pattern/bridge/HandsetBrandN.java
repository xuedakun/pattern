package cn.com.pattern.bridge;

/**
 * 手机品牌N
 * 
 * @author ripper
 *
 */
public class HandsetBrandN extends HandsetBrand {

	public HandsetBrandN() {
		System.out.print("N型手机");
	}

	@Override
	public void run() {
		soft.run();
	}

}
