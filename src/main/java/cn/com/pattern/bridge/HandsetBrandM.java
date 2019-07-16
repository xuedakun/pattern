package cn.com.pattern.bridge;

/**
 * 手机品牌M
 * 
 * @author ripper
 *
 */
public class HandsetBrandM extends HandsetBrand {

	public HandsetBrandM() {
		System.out.print("M型手机");
	}

	@Override
	public void run() {
		soft.run();
	}

}
