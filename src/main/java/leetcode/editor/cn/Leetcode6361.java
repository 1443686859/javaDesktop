package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6361 {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 3) {
            return 0;
        }
        return Math.min(nums[nums.length - 3] - nums[0], Math.min(nums[nums.length - 1] - nums[2], nums[nums.length - 2] - nums[1]));
    }
}
