package cn.com.algorithm;

import org.json.JSONObject;

/**
 * @author xuekun
 * @create 2020-01-03 10:56
 **/
public class Duplicate {

    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4, 4, 6, 7, 8};
        int[] duplication = new int[number.length];
        Duplicate duplicate = new Duplicate();
        duplicate.duplicate(number, number.length, duplication);
        System.out.println(JSONObject.valueToString(duplication));
    }

}
