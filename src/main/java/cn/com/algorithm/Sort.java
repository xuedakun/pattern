package cn.com.algorithm;

public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    /**
     * 比较
     * 判断v是否小于w 如果是返回true 如果不是 返回false
     * @param v
     * @param w
     * @return
     */
    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换
     *
     * @param a
     * @param i
     * @param j
     */
    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
