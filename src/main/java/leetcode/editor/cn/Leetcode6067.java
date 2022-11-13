package leetcode.editor.cn;

public class Leetcode6067 {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];
        result[0] = nums[0];
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        int count = 0;
        long last = result[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (last - result[i] <= result[i]) {
                count++;
            }
        }
        return count;
    }
}
