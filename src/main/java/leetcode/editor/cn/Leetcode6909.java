package leetcode.editor.cn;

public class Leetcode6909 {
    public static void main(String[] args) {
        Leetcode6909 leetcode6909 = new Leetcode6909();
        System.out.println(leetcode6909.longestAlternatingSubarray(new int[]{3,2,5,4}, 5));
    }
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > threshold) {
                nums[i] =- 1;
            } else {
                nums[i] = nums[i] % 2;
                if (nums[i] == 0) {
                    max = 1;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 || nums[i] == - 1) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (check(i, j, nums)) {
                    max = Math.max(max, j - i  + 1);
                }
            }
        }
        return max;
    }
    private boolean check(int left, int right, int[] nums) {
        for (int i = left; i < right; i++) {
            if (nums[i] == nums[i + 1]) {
                return false;
            }
            if (nums[i] == -1 || nums[i + 1] == - 1) {
                return false;
            }
        }
        return true;
    }
}
