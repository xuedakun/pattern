package cn.com.algorithm;

public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] aux;


    protected void merge(T[] nums, int l, int m, int h) {

        int p1 = l, p2 = m + 1;

        for (int k = l; k <= h; k++) {
            // 将数据复制到辅助数组
            aux[k] = nums[k];
        }

        for (int k = l; k <= h; k++) {
            if (p1 > m) {
                nums[k] = aux[p2++];
            } else if (p2 > h) {
                nums[k] = aux[p1++];
            } else if (aux[p1].compareTo(aux[p2]) <= 0) {
                // 先进行这一步，保证稳定性
                nums[k] = aux[p1++];
            } else {
                nums[k] = aux[p2++];
            }
        }
    }

}
