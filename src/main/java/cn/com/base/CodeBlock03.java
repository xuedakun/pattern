package cn.com.base;

import java.util.ArrayList;

class Code {
  {
    System.out.println("Code的构造块");
  }

  static {
    System.out.println("Code的静态代码块");
  }

  public Code() {
    System.out.println("Code的构造方法");
  }
}


public class CodeBlock03 {
  {
    System.out.println("CodeBlock03的构造块");
  }

  static {
    System.out.println("CodeBlock03的静态代码块");
  }

  public CodeBlock03() {
    System.out.println("CodeBlock03的构造方法");
  }

  public static void main(String[] args) {
    System.out.println("CodeBlock03的主方法");
    new Code();
    new Code();
    new CodeBlock03();
    new CodeBlock03();
  }
}
