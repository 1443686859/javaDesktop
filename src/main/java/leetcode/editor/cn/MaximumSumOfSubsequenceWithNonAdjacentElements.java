/**
给你一个整数数组 nums 和一个二维数组 queries，其中 queries[i] = [posi, xi]。 

 对于每个查询 i，首先将 nums[posi] 设置为 xi，然后计算查询 i 的答案，该答案为 nums 中 不包含相邻元素 的 子序列 的 最大 和。 

 返回所有查询的答案之和。 

 由于最终答案可能非常大，返回其对 10⁹ + 7 取余 的结果。 

 子序列 是指从另一个数组中删除一些或不删除元素而不改变剩余元素顺序得到的数组。 

 

 示例 1： 

 
 输入：nums = [3,5,9], queries = [[1,-2],[0,-3]] 
 

 输出：21 

 解释： 执行第 1 个查询后，nums = [3,-2,9]，不包含相邻元素的子序列的最大和为 3 + 9 = 12。 执行第 2 个查询后，nums = [
-3,-2,9]，不包含相邻元素的子序列的最大和为 9 。 

 示例 2： 

 
 输入：nums = [0,-1], queries = [[0,-5]] 
 

 输出：0 

 解释： 执行第 1 个查询后，nums = [-5,-1]，不包含相邻元素的子序列的最大和为 0（选择空子序列）。 

 

 提示： 

 
 1 <= nums.length <= 5 * 10⁴ 
 -10⁵ <= nums[i] <= 10⁵ 
 1 <= queries.length <= 5 * 10⁴ 
 queries[i] == [posi, xi] 
 0 <= posi <= nums.length - 1 
 -10⁵ <= xi <= 10⁵ 
 

 👍 40 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-10-31 21:35:07
 */
public class MaximumSumOfSubsequenceWithNonAdjacentElements{
    public static void main(String[] args) {
        Solution solution = new MaximumSumOfSubsequenceWithNonAdjacentElements().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
       int max = 2 << (32 - Integer.numberOfLeadingZeros(nums.length));
       int[][] dp = new int[max][4];
       build(dp, nums, 1, 0, nums.length - 1);
       long result = 0;
       for (int[] query : queries) {
           update(dp, 1, 0, nums.length - 1, query[0], query[1]);
           result += dp[1][3];
       }
       return (int) result;
    }
    public void update(int[][] dp, int p, int left, int right, int index, int val) {
        if (left == right) {
            dp[p][3] = Math.max(val, 0);
            return;
        }
        int m = (left + right) / 2;
        if (index <= m) {
            update(dp, p * 2, left, m, index, val);
        } else {
            update(dp, p * 2 + 1, m + 1, right, index, val);
        }
        maintain(dp, p);
    }
    public void build(int[][] dp, int[] nums, int p, int left, int right) {
        if (left == right) {
            dp[p][3] = Math.max(0, nums[left]);
            return ;
        }
        int m  = (left + right) / 2;
        build(dp, nums, p * 2, left, m);
        build(dp, nums, p * 2 + 1, m + 1, right);
        maintain(dp, p);
    }
    public void maintain(int[][] dp, int p) {
        int left = 2 * p;
        int right = 2 * p + 1;
        dp[p][0] = Math.max(dp[left][0] + dp[right][2], dp[left][1] + dp[right][0]);
        dp[p][1] = Math.max(dp[left][0] + dp[right][3], dp[left][1] + dp[right][1]);
        dp[p][2] = Math.max(dp[left][3] + dp[right][0], dp[left][2] + dp[right][2]);
        dp[p][3] = Math.max(dp[left][2] + dp[right][3], dp[left][3] + dp[right][1]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}