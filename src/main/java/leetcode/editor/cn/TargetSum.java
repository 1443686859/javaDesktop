/**
给你一个非负整数数组 nums 和一个整数 target 。 

 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 

 
 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
 

 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 

 

 示例 1： 

 
输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
 

 示例 2： 

 
输入：nums = [1], target = 1
输出：1
 

 

 提示： 

 
 1 <= nums.length <= 20 
 0 <= nums[i] <= 1000 
 0 <= sum(nums[i]) <= 1000 
 -1000 <= target <= 1000 
 

 👍 1930 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-06-30 00:54:08
 */
public class TargetSum{
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53}, 1000));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        int sum;

    public int findTargetSumWays(int[] nums, int target) {
        sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int max = sum - Math.abs(target);
        if (max < 0 || max % 2 != 0) {
            return 0;
        }
        max /= 2;
        int[] dp = new int[max + 1];
        dp[0] = 1;
        for (int x : nums) {
            for (int i = max; i >= x; i--) {
                dp[i] += dp[i - x];
            }
        }
        return dp[max];
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}