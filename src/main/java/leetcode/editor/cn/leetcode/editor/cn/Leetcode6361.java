package leetcode.editor.cn.leetcode.editor.cn;

public class Leetcode6361 {
    public int diagonalPrime(int[][] nums) {
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n;j++) {
                if (i == j || j == n - i - 1) {
                    if (check(nums[i][j])) {
                        max = Math.max(max, nums[i][j]);
                    }
                }
            }
        }
        return max;
    }
    public boolean check(int target) {
        for (int i = 2; i * i <= target; i++) {
            if (target % i == 0) {
                return false;
            }
        }
        return true;
    }
}
