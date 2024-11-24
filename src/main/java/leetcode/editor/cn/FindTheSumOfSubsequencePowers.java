/**
给你一个长度为 n 的整数数组 nums 和一个 正 整数 k 。 

 一个 子序列 的 能量 定义为子序列中 任意 两个元素的差值绝对值的 最小值 。 

 请你返回 nums 中长度 等于 k 的 所有 子序列的 能量和 。 

 由于答案可能会很大，将答案对 109 + 7 取余 后返回。 

 

 示例 1： 

 
 输入：nums = [1,2,3,4], k = 3 
 

 输出：4 

 解释： 

 nums 中总共有 4 个长度为 3 的子序列：[1,2,3] ，[1,3,4] ，[1,2,4] 和 [2,3,4] 。能量和为 |2 - 3| + |3 
- 4| + |2 - 1| + |3 - 4| = 4 。 

 示例 2： 

 
 输入：nums = [2,2], k = 2 
 

 输出：0 

 解释： 

 nums 中唯一一个长度为 2 的子序列是 [2,2] 。能量和为 |2 - 2| = 0 。 

 示例 3： 

 
 输入：nums = [4,3,-1], k = 2 
 

 输出：10 

 解释： 

 nums 总共有 3 个长度为 2 的子序列：[4,3] ，[4,-1] 和 [3,-1] 。能量和为 |4 - 3| + |4 - (-1)| + |3 -
 (-1)| = 10 。 

 

 提示： 

 
 2 <= n == nums.length <= 50 
 -10⁸ <= nums[i] <= 10⁸ 
 2 <= k <= n 
 

 👍 33 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author  YourName
 * @date 2024-07-23 21:05:20
 */
public class FindTheSumOfSubsequencePowers{
    public static void main(String[] args) {
        Solution solution = new FindTheSumOfSubsequencePowers().new Solution();
//        System.out.println(solution.sumOfPowers(new int[]{1, 2,3,4}, 3));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private int[] nums;
//    public int sumOfPowers(int[] nums, int k) {
//        this.nums = nums;
//    }
//    public int dfs(int pre, int current, int min, int count) {
//        if (count == 0) {
//            return min;
//        }
//        if (nums.length - current < count) {
//            return 0;
//        }
//
//    }

}
//leetcode submit region end(Prohibit modification and deletion)

}