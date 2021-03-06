package cn.com.algorithm.skiplist;

import java.util.Random;

/** 不固定层级的跳跃表 created by 曹艳丰，2016-08-14 参考：http://www.acmerblog.com/skip-list-impl-java-5773.html */
public class SkipList<T> {
  private SkipListNode<T> head, tail;
  private int nodes; // 节点总数
  private int listLevel; // 层数
  private final Random random; // 用于投掷硬币
  private static final double PROBABILITY = 0.5; // 向上提升一个的概率

  public SkipList() {
    random = new Random();
    clear();
  }
  /** 清空跳跃表 */
  public void clear() {
    head = new SkipListNode<T>(SkipListNode.HEAD_KEY, null);
    tail = new SkipListNode<T>(SkipListNode.TAIL_KEY, null);
    horizontalLink(head, tail);
    listLevel = 0;
    nodes = 0;
  }

  public boolean isEmpty() {
    return nodes == 0;
  }

  public int size() {
    return nodes;
  }
  /** 在最下面一层，找到要插入的位置前面的那个key */
  private SkipListNode<T> findNode(int key) {
    SkipListNode<T> p = head;
    while (true) {
      while (p.right.key != SkipListNode.TAIL_KEY && p.right.key <= key) {
        p = p.right;
      }
      if (p.down != null) {
        p = p.down;
      } else {
        break;
      }
    }
    return p;
  }
  /** 查找是否存储key，存在则返回该节点，否则返回null */
  public SkipListNode<T> search(int key) {
    SkipListNode<T> p = findNode(key);
    if (key == p.getKey()) {
      return p;
    } else {
      return null;
    }
  }
  /** 向跳跃表中添加key-value */
  public void put(int k, T v) {
    SkipListNode<T> p = findNode(k);
    // 如果key值相同，替换原来的vaule即可结束
    if (k == p.getKey()) {
      p.value = v;
      return;
    }
    SkipListNode<T> q = new SkipListNode<T>(k, 0, v);
    backLink(p, q);
    // 当前所在的层级是0
    int currentLevel = 0;
    // 抛硬币
    while (random.nextDouble() < PROBABILITY) {
      // 如果超出了高度，需要重新建一个顶层
      if (currentLevel >= listLevel) {
        listLevel++;
        SkipListNode<T> p1 = new SkipListNode<T>(SkipListNode.HEAD_KEY, null);
        SkipListNode<T> p2 = new SkipListNode<T>(SkipListNode.TAIL_KEY, null);
        horizontalLink(p1, p2);
        vertiacallLink(p1, head);
        vertiacallLink(p2, tail);
        head = p1;
        tail = p2;
      }
      // 将p移动到上一层
      int span = q.span;
      while (p.up == null) {
        span = span + p.span;
        p = p.left;
        span++;
      }

      p = p.up;

      SkipListNode<T> e = new SkipListNode<T>(k, span, null); // 只保存key就ok
      backLink(p, e); // 将e插入到p的后面
      vertiacallLink(e, q); // 将e和q上下连接
      q = e;
      currentLevel++;
    }
    if (currentLevel < listLevel) {
      // 更新此节点右节点span
      SkipListNode rightNode = q.right;
      while (true) {
        if (rightNode.right == null) {
          break;
        }
        if (rightNode.up != null) {
          rightNode = rightNode.up;
          rightNode.setSpan(rightNode.getSpan() + 1);
        } else {
          rightNode = rightNode.right;
        }
      }
    }

    nodes++; // 层数递增
  }
  // node1后面插入node2
  private void backLink(SkipListNode<T> node1, SkipListNode<T> node2) {
    SkipListNode rightNode = node1.right;
    node1.right = node2;
    node2.left = node1;
    node2.right = rightNode;
    rightNode.left = node2;
    rightNode.setSpan(rightNode.span - node2.getSpan());
  }
  /** 水平双向连接 */
  private void horizontalLink(SkipListNode<T> node1, SkipListNode<T> node2) {
    node1.right = node2;
    node2.left = node1;
  }
  /** 垂直双向连接 */
  private void vertiacallLink(SkipListNode<T> node1, SkipListNode<T> node2) {
    node1.down = node2;
    node2.up = node1;
  }

  /*public List<RankSkipListNode> rank() {
    List<RankSkipListNode> list = new ArrayList<RankSkipListNode>();
  }*/

  /**
   * 在跳跃表中删除key
   *
   * @param key
   */
  public void remove(int key) {
    SkipListNode<T> p = findNode(key);
    if (key == p.getKey()) {
      while (true) {
        SkipListNode<T> left = p.left;
        SkipListNode<T> right = p.right;
        if (left.equals(head) && right.equals(tail)) {
          head = head.down;
          tail = tail.down;
          p = null;
          listLevel--;
          break;
        }
        horizontalLink(left, right);
        right.setSpan(right.getSpan() + p.getSpan());
        nodes--;
        if (p.up != null) {
          p = p.up;
        } else {
          // 更新此节点右节点span
          SkipListNode rightNode = p;
          while (rightNode.right != null) {
            if (rightNode.up != null) {
              rightNode = rightNode.up;
              rightNode.setSpan(rightNode.getSpan() - 1);
            } else {
              rightNode = rightNode.right;
            }
          }
          break;
        }
      }

    } else {
      System.out.println("该节点不存在");
    }
  }

  private String treate(SkipListNode<T> p) {
    StringBuilder builder = new StringBuilder();
    /*    while (p.left != null) {
      p = p.left;
    }
    if (p.right != null) {
      p = p.right;
    }*/
    while (p.right != null) {
      builder.append(p.toString());
      p = p.right;
    }
    return builder.toString();
  }
  /** 打印出原始数据 */
  @Override
  public String toString() {
    //
    if (isEmpty()) {
      return "跳跃表为空！";
    }
    StringBuilder builder = new StringBuilder();
    SkipListNode<T> p = head;
    while (p != null) {
      builder.append(treate(p) + "\n");
      p = p.down;
    }

    /* while (p.down != null) {
      p = p.down;
    }

    while (p.left != null) {
      p = p.left;
    }
    if (p.right != null) {
      p = p.right;
    }
    while (p.right != null) {
      builder.append(p);
      builder.append("\n");
      p = p.right;
    }*/

    return builder.toString();
  }
}
