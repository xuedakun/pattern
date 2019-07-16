package cn.com.code151;

import java.io.Serializable;

public class Person implements Serializable {
  /**
   * 1、反序列化时 构造函数不会执行
   */
  private static final long serialVersionUID = 1L;
  public final String name = initName();
  public String initName() {
    return "钱包金服";
  }
}
