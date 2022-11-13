package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode6049 {
    public int countDistinct(int[] nums, int k, int p) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int currentCount = nums[i] % p == 0 ? 1 : 0;
            set.add(nums[i]);
            int length = 1;
            while (currentCount < k && i + length < nums.length) {
                 if (nums[i + length]% p == 0) {
                     currentCount++;
                 }
                 length++;
                 result++;
            }
        }
        return result + set.size();
    }
}
