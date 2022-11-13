package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Leetcode6230 {
    public static void main(String[] args) {
        Leetcode6230 leetcode6230 = new Leetcode6230();
        System.out.println(leetcode6230.maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
    }
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length ;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        Set<Integer> base = new HashSet<>();
        int start = 0;
        long result = 0;
        for (int i = 0; i < n; i++) {

            if (!base.add(nums[i])) {
                while (!base.add(nums[i])) {
                    base.remove(nums[start++]);
                }
            }
            if (base.size() > k) {
                while (base.size() > k) {
                    base.remove(nums[start++]);
                }
            }
            if (base.size() == k) {
                result = Math.max(result, sum[i + 1] - sum[start]);
            }
        }
        return result;
    }
}
