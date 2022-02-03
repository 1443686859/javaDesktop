package leetcode.editor.cn;
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n²) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 👍 2149 👎 0

import java.util.Arrays;

public class P300LongestIncreasingSubsequence{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  /*  public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }*/
  public int lengthOfLIS(int[] nums) {
      int len = 1;
      int n = nums.length;
      if (n == 0) {
          return 0;
      }
      int[] d = new int[n + 1];
      d[len] = nums[0];
      for (int i = 1; i < n; i++) {
          if (nums[i] > d[len]) {
              d[++len] = nums[i];
          } else {
              int l = 1;
              int r = len;
              int pos = 0;
              while (l <= r) {
                  int mid = (l + r) / 2;
                  if (d[mid] < nums[i]) {
                      pos = mid;
                      l = mid + 1;
                  } else {
                      r = mid - 1;
                  }
              }
              d[l] = nums[i];
          }
      }
      return len;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

}