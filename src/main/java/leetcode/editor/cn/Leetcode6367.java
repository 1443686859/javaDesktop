package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6367 {
    public static void main(String[] args) {
        Leetcode6367 leetcode6367 = new Leetcode6367();
        System.out.println(leetcode6367.maxNumOfMarkedIndices(new int[]{7,6,8}));
    }
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int n = nums.length;
        boolean[] used = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            if (used[i]) {
                break;
            }
            int target = nums[i] / 2;
            int right = i - 1;
            int left = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] < target) {
                    left ++;
                } else {
                    right --;
                }
            }
            if (right + 1 < n && nums[right + 1] <= target && !used[right + 1]) {
                used[right + 1] = true;
                used[i] = true;
                result += 2;
            }
        }
        return result;
    }
}
