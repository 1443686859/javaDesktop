//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划

package com.leetcode.editor.cn;
public class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();
        int a[] = {1,2,3,2,1};
        int b[] = {3,2,1,4,7};
//        solution.findLength(a, b);
        System.out.println(solution.findLength2(a, b));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] a, int[] b) {
        // 建立一个二维数组存储放置：长度为 i，末尾项为 A[i-1] 的子数组，长度为 j，末尾项为 B[j-1] 的子数组，二者的最长公共连续子数组长度
        // dp转移方程： 数组中的每个值都由dp[i-1][j-1] 和 当前的数组值决
        int[][] dp = new int[a.length + 1][b.length + 1];
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = dp[i][j] > max ? dp[i][j] : max;
            }
        }
        return max;
    }
    public int findLength2(int[] a, int[] b) {
        int[] length = new int[b.length + 1];
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = b.length; j >= 0; j--) {
                if (a[i - 1] == b[j - 1]) {
                    length[j] = length[j - 1] + 1;
                } else {
                    length[i] = 0;
                }
                max = length[j] > max ? length[j] : max;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}