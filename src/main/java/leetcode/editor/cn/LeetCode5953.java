package leetcode.editor.cn;

import java.util.Arrays;

public class LeetCode5953 {
    public long subArrayRanges(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        long result = 0;
        while (left <= right && left < nums.length && right >= 0 && nums[left] != nums[right]) {
            result += Math.pow(2, right -left - 1) * (nums[right] - nums[left]);
            while (left < nums.length && nums[left] == nums[left + 1]) {
                left++;
            }
            left ++;
            while (right >= 1 && nums[right - 1] == nums[right]) {
                right --;
            }
            right--;
        }
        return result;
    }

}
