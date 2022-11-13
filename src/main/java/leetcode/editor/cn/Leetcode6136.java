package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Leetcode6136 {
    public int arithmeticTriplets(int[] nums, int diff) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            int j = map.getOrDefault(nums[i] - diff, -1);
            if (j == -1) {
                continue;
            }
            int currentI = map.getOrDefault(nums[j] - diff, -1);
            if (currentI == -1) {
                continue;
            }
            count++;
        }
        return count;
    }
}
