package leetcode.editor.cn;

public class Leetcode6449 {
    public long minCost(int[] nums, int x) {
        long[] result = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        long sum = 0;
        int max = 0;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                result[j] = Math.min(result[j], nums[i] + ((j - i + n) % n) * x);
            }

        }
        return sum;
    }
}
