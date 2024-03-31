package leetcode.editor.cn;

public class Leetcode6334 {
    public long[] findPrefixScore(int[] nums) {
        int[] score = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            score[i] = nums[i] + max;
        }
        long[] sum = new long[nums.length];
        sum[0] = score[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + score[i];
        }
        return sum;
    }
}
