package cn.com.algorithm.skiplist;

/** @Author:xuekun @Description: 跳跃表节点 @DateTime:2020/6/1 11:07 */
public class SkipListNode<T> {
  public int key;
  // 从前一个节点沿着当前层的 forward 指针跳到当前这个节点中间会跳过多少个节点
  public int span;
  public T value;
  // 上下左右 四个指针
  public SkipListNode<T> up, down, left, right;
  // 负无穷
  public static final int HEAD_KEY = Integer.MIN_VALUE;
  // 正无穷
  public static final int TAIL_KEY = Integer.MAX_VALUE;

  public int getSpan() {
    return span;
  }

  public void setSpan(int span) {
    this.span = span;
  }

  public SkipListNode(int key, int span, T value) {
    this.key = key;
    this.span = span;
    this.value = value;
  }

  public SkipListNode(int k, T v) {
    key = k;
    value = v;
    this.span = 0;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (!(o instanceof SkipListNode<?>)) {
      return false;
    }
    SkipListNode<T> ent;
    try {
      // 检测类型
      ent = (SkipListNode<T>) o;
    } catch (ClassCastException ex) {
      return false;
    }
    return (ent.getKey() == key) && (ent.getValue() == value);
  }

  @Override
  public String toString() {
    String str = "";
    for (int i = 0; i < span; i++) {
      str += "[     ]-";
    }
    return str + "[" + key + "]-";
  }
}
