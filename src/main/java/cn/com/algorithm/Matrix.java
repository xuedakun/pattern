package cn.com.algorithm;

import jdk.nashorn.internal.runtime.Source;
import sun.security.util.Length;

/**
 * @Author:xuekun
 * @Description: 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * @DateTime:2020/1/7 14:31
 */
public class Matrix {
    public static Boolean find(Integer target, int[][] matrix) {
        if (target == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int length = matrix.length - 1;
        int width = matrix[0].length - 1;
        int r = 0;
        while (width >= 0 && r <= length) {
            if (matrix[r][width] == target) {
                return true;
            } else if (matrix[r][width] < target) {
                r++;
            } else {
                width--;
            }
        }
      /*  for (int i = 0; i <= length; i++) {
            if (matrix[i][width] > target && width > 0) {
                for (int j = width; width >= 0; width--) {
                    if (matrix[i][width] == target) {
                        return true;
                    }
                    if (matrix[i][width] < target) {
                        break;
                    }
                }
            }
            if (matrix[i][width] == target) {
                return true;
            }
        }*/
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(Matrix.find(25, arr));
    }
}
