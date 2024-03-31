package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6316 {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        long sum = 0;
        int result = 0;
        for (int i : nums) {
            if (sum + i <= 0) {
                break;
            }
            sum += i;
            result++;
        }
        return result;
    }
}
