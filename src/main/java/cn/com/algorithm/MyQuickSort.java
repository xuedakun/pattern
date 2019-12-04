package cn.com.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xuekun
 * @create 2019-11-28 14:50
 **/
public class MyQuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        //先给nums洗牌
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
        quickSort(nums, 0, nums.length - 1);

    }

    private int partition(T[] nums, int left, int right) {
        //取出格子
        T temp = nums[left];
        int i = left;
        int j = right + 1;
        while (true) {
            while (less(nums[++i], temp) && i != right) {
            }
            while (less(temp, nums[--j]) && j != left) {
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    public void quickSort(T[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int midIndex = partition(nums, left, right);
        quickSort(nums, left, midIndex - 1);
        quickSort(nums, midIndex + 1, right);
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 6, 7, 8, 9, 10, 18, 11, 14, 19, 50, 54, 69};
        MyQuickSort myQuickSort = new MyQuickSort();
        myQuickSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
