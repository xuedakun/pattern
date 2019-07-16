package cn.com.pattern.bridge;

public class HandsetTest {
	public static void main(String[] args) {
		HandsetBrand m = new HandsetBrandM();
		HandsetSoft game = new HandsetGame();
		m.soft = game;
		m.run();

		HandsetBrand n = new HandsetBrandN();
		HandsetSoft address = new HandsetAddressList();
		n.soft = address;
		n.run();

	}
}
