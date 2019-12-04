package cn.com.algorithm;

import javax.xml.transform.Source;

/**
 * @author xuekun
 * @create 2019-11-27 15:56
 **/
public class MyMergeSort {
    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    public static void sort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);

    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L+1];
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            arr[L + j] = temp[j];
            //System.out.println(temp[j]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7,10,5,50,6,69,54,10,11,19,14 };
        MyMergeSort.mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

}
