package cn.com.base;

import java.util.ArrayList;
import java.util.List;


public class Test {

  public static void treate1(List<Integer> list) {
    list.add(4);
  }

  public static void treate2(List<Integer> list) {
    list.add(5);
    list = new ArrayList<>();
    list.add(6);
  }

  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    for (Integer i : list) {
      System.out.println(i);
    }
    Test.treate1(list);
    for (Integer i : list) {
      System.out.println(i);
    }
    Test.treate2(list);
    for (Integer i : list) {
      System.out.println(i);
    }
  }
}
