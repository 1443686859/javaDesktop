/**
给你一个下标从 0 开始的整数数组 nums 和一个正整数 x 。 

 你 一开始 在数组的位置 0 处，你可以按照下述规则访问数组中的其他位置： 

 
 如果你当前在位置 i ，那么你可以移动到满足 i < j 的 任意 位置 j 。 
 对于你访问的位置 i ，你可以获得分数 nums[i] 。 
 如果你从位置 i 移动到位置 j 且 nums[i] 和 nums[j] 的 奇偶性 不同，那么你将失去分数 x 。 
 

 请你返回你能得到的 最大 得分之和。 

 注意 ，你一开始的分数为 nums[0] 。 

 

 示例 1： 

 输入：nums = [2,3,6,1,9,2], x = 5
输出：13
解释：我们可以按顺序访问数组中的位置：0 -> 2 -> 3 -> 4 。
对应位置的值为 2 ，6 ，1 和 9 。因为 6 和 1 的奇偶性不同，所以下标从 2 -> 3 让你失去 x = 5 分。
总得分为：2 + 6 + 1 + 9 - 5 = 13 。
 

 示例 2： 

 输入：nums = [2,4,6,8], x = 3
输出：20
解释：数组中的所有元素奇偶性都一样，所以我们可以将每个元素都访问一次，而且不会失去任何分数。
总得分为：2 + 4 + 6 + 8 = 20 。
 

 

 提示： 

 
 2 <= nums.length <= 10⁵ 
 1 <= nums[i], x <= 10⁶ 
 

 👍 12 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-06-14 00:44:54
 */
public class VisitArrayPositionsToMaximizeScore{
    public static void main(String[] args) {
        Solution solution = new VisitArrayPositionsToMaximizeScore().new Solution();
        System.out.println(solution.maxScore(new int[]{8,50,65,85,8,73,55,50,29,95,5,68,52,79},74));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        int index = nums[0] & 1;
        dp[0][index] = nums[0];
        dp[0][1 ^ index] = nums[0] - x;
        for (int i = 1; i < n; i++) {
            index = nums[i] & 1;
            dp[i][index] = Math.max(dp[i - 1][index] + nums[i], dp[i - 1][index ^ 1] + nums[i] - x);
            dp[i][index ^ 1] = Math.max(dp[i - 1][index] + nums[i] - x, dp[i - 1][index ^ 1]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}