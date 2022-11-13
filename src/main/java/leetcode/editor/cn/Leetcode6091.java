package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6091 {
    public static void main(String[] args) {
        Leetcode6091 leetcode6091 = new Leetcode6091();
        System.out.println(leetcode6091.partitionArray(new int[]{2,2,4,5}, 0));
    }
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 1;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - nums[left]) > k) {
                result++;
                left = i;
            }
        }
        return result;
    }
}
