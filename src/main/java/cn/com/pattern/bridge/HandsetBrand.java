package cn.com.pattern.bridge;

/**
 * 手机品牌
 * 
 * @author ripper
 *
 */
public abstract class HandsetBrand {

	public abstract void run();

	protected HandsetSoft soft;

	public HandsetBrand(HandsetSoft soft) {
		this.soft = soft;
	}

	public HandsetBrand() {
	}

	public void setSoft(HandsetSoft soft) {
		this.soft = soft;
	}

	public HandsetSoft getSoft() {
		return soft;
	}
}
