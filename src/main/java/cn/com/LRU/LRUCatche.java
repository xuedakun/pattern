package cn.com.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xuekun
 * @create 2019-11-29 16:17
 */
public class LRUCatche<K, V> extends LinkedHashMap<K, V> {
  private static final int MAX_CATCH_MUMBER = 3;

  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return size() > MAX_CATCH_MUMBER;
  }

  public LRUCatche() {
    super(MAX_CATCH_MUMBER, 0.75f, true);
  }

  public static void main(String[] args) {
    LRUCatche<Integer, String> catche = new LRUCatche<>();
    catche.put(1, "a");
    catche.put(2, "b");
    catche.put(3, "c");
    catche.get(1);
    catche.get(2);
    catche.put(4, "d");
    System.out.println(catche.keySet());
  }
}
