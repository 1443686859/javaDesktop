/**
给你一个整数数组 nums 和一个 非负 整数 k 。如果一个整数序列 seq 满足在范围下标范围 [0, seq.length - 2] 中存在 不超过 k 
个下标 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。 

 请你返回 nums 中 好 子序列 的最长长度 

 

 示例 1： 

 
 输入：nums = [1,2,1,1,3], k = 2 
 

 输出：4 

 解释： 

 最长好子序列为 [1,2,1,1,3] 。 

 示例 2： 

 
 输入：nums = [1,2,3,4,5,1], k = 0 
 

 输出：2 

 解释： 

 最长好子序列为 [1,2,3,4,5,1] 。 

 

 提示： 

 
 1 <= nums.length <= 5 * 10³ 
 1 <= nums[i] <= 10⁹ 
 0 <= k <= min(50, nums.length) 
 

 👍 9 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2024-09-06 19:51:03
 */
public class FindTheMaximumLengthOfAGoodSubsequenceIi{
    public static void main(String[] args) {
        Solution solution = new FindTheMaximumLengthOfAGoodSubsequenceIi().new Solution();
        System.out.println(solution.maximumLength(new int[]{1,2,1,1,3}, 2));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = 0;
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, m++);
            }
        }
        int[][] dp = new int[m][k + 1];
        int[] maxArray = new int[k + 1];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
             int index = map.get(nums[i]);
             for (int j = Math.min(i, k); j >= 0; j--) {
                 dp[index][j] = Math.max(dp[index][j] + 1, j == 0 ? 0 : (maxArray[j - 1] + 1));
                 max = Math.max(dp[index][j], max);
                 maxArray[j] = Math.max(maxArray[j], dp[index][j]);
             }
        }
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}