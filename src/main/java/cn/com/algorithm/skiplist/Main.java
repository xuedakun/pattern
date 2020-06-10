package cn.com.algorithm.skiplist;

public class Main {
  public static int getRandom(int start, int end) {

    int num = (int) (Math.random() * (end - start + 1) + start);
    return num;
  }

  public static void main(String[] args) {
    SkipList<String> list = new SkipList<String>();
    for (int i = 0; i < 10000; i++) {
      list.put(getRandom(10000, 99990), "xxx" + getRandom(100, 9999));
    }

    System.out.println(list.toString());
  }
}
