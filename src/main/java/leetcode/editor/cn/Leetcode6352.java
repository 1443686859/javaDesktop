package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode6352 {
    public int beautifulSubsets(int[] nums, int k) {
        int baseResult = (int)Math.pow(2, nums.length);
        baseResult -= 1;
        Arrays.sort(nums);
        int result = 0;
        for (int i = baseResult; i > 0; i--) {
            if (check(nums, i, k)) {
                result++;
            }
        }
        return result;
    }
    public boolean check(int[] nums, int mask, int k) {
        int[] count = new int[1001];
        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) != 0) {
                if (nums[i] - k >= 0 && count[nums[i] - k] != 0) {
                    return false;
                }
                if (nums[i] + k < 1000 && count[nums[i] + k] != 0) {
                    return false;
                }
                count[nums[i]] ++;
            }
        }
        return true;
    }
}
