package cn.com.base;

//父类
class Parent {  
  private int i = 9;
  protected int j;

  public Parent() {  
      System.out.println("i = " + i + ",j=" + j);  
      j = 39;  
  }  
  
  static{
      System.out.println("parent静态块 run...");
  }
  
  {
      System.out.println("parent代码块 run...");
  }

  private static int x1 = printInit("static intx1 initialized");

  static int printInit(String s) {  
      System.out.println(s);  
      return 47;  
  }  
}  

//子类
public class Child extends Parent {  
  final int k = printInit("child.k initialized");  

  Child() {  
      System.out.println("k=" + k);  
      System.out.println("j = " + j);  
  }  
  
  {
      System.out.println("child代码块 run...");
  }

  private static int x2 = printInit("static child.x2 initialized");  
  
  static{
      System.out.println("child静态块 run...");
  }

  public static void main(String[] args) {  
      System.out.println("child constructor");  
      Child b = new Child();  
      //child静态块 run...
      //
  }  
}  
