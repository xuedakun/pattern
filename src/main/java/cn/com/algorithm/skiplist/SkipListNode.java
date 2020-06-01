package cn.com.algorithm.skiplist;

/** @Author:xuekun @Description: 跳跃表节点 @DateTime:2020/6/1 11:07 */
public class SkipListNode<T> {
  public int key;
  public T value;
  // 上下左右 四个指针
  public SkipListNode<T> up, down, left, right;
  // 负无穷
  public static final int HEAD_KEY = Integer.MIN_VALUE;
  // 正无穷
  public static final int TAIL_KEY = Integer.MAX_VALUE;

  public SkipListNode(int k, T v) {
    key = k;
    value = v;
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
    return "key-value:" + key + "-" + value;
  }
}
