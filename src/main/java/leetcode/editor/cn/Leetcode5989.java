package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode5989 {
    public int countElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[n - 1];
         int result = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] < max && nums[i] > min) {
                result ++;
            }
        }
        return result;
    }
}
