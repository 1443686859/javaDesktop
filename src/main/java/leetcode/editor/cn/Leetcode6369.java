package leetcode.editor.cn;

public class Leetcode6369 {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int pre = 0;
        for (int i = 0; i < n; i++) {
            ans[i] = Math.abs((sum - pre - nums[i]) - pre);
            pre += nums[i];
        }
        return ans;
    }
}
