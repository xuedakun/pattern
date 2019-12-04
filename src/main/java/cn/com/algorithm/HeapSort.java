package cn.com.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    /**
     * 数组第 0 个位置不能有元素
     */
    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;
        for (int k = N / 2; k >= 1; k--) {
            sink(nums, k, N);
        }
        while (N > 1) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
    }

    private void sink(T[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(nums, j, j + 1)) {
                j++;
            }
            if (!less(nums, k, j)) {
                break;
            }
            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
    }
    public static void main(String[] args) {
        Integer[] arr = {5, 6, 7, 8, 9, 10, 18, 11, 14, 19, 50, 54, 69};
        List<Comparable> list = Arrays.asList(arr);
        Collections.shuffle(list);
        list.toArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
