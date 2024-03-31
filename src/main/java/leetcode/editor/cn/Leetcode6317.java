package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Leetcode6317 {
    public static void main(String[] args) {
        Leetcode6317 leetcode6317 = new Leetcode6317();
        System.out.println(leetcode6317.beautifulSubarrays(new int[]{4,3,1,2,4}));
    }
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int preSum = 0;
        long result = 0;
        countMap.put(0, 1);
        for (int i : nums) {
            preSum = get(preSum, i);
            result += countMap.getOrDefault(preSum, 0);
            countMap.put(preSum, countMap.getOrDefault(preSum, 0) + 1);
        }
        return result;
    }
    public int get(int result, int target) {
        for (int i = 0; i < 32; i++) {
            if ((target & (1 << i)) != 0) {
                result ^= 1 << i;
            }
        }
        return result;
    }
}
