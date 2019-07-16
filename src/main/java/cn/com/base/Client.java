package cn.com.base;

public class Client {


	public static String  test1(int n) {
	  String string="";
		switch (n) {
          case 1:string="一";
          case 2:string="二";
          case 3:string="三";
          case 4:string="四";
          case 5:string="五";
        }
		return string;
	}
	public static void main(String[] args) {
	 System.out.println("2="+Client.test1(2));
    }

	
}
