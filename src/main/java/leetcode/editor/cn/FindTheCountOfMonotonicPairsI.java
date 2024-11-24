/**
给你一个长度为 n 的 正 整数数组 nums 。 

 如果两个 非负 整数数组 (arr1, arr2) 满足以下条件，我们称它们是 单调 数组对： 

 
 两个数组的长度都是 n 。 
 arr1 是单调 非递减 的，换句话说 arr1[0] <= arr1[1] <= ... <= arr1[n - 1] 。 
 arr2 是单调 非递增 的，换句话说 arr2[0] >= arr2[1] >= ... >= arr2[n - 1] 。 
 对于所有的 0 <= i <= n - 1 都有 arr1[i] + arr2[i] == nums[i] 。 
 

 请你返回所有 单调 数组对的数目。 

 由于答案可能很大，请你将它对 10⁹ + 7 取余 后返回。 

 

 示例 1： 

 
 输入：nums = [2,3,2] 
 

 输出：4 

 解释： 

 单调数组对包括： 

 
 ([0, 1, 1], [2, 2, 1]) 
 ([0, 1, 2], [2, 2, 0]) 
 ([0, 2, 2], [2, 1, 0]) 
 ([1, 2, 2], [1, 1, 0]) 
 

 示例 2： 

 
 输入：nums = [5,5,5,5] 
 

 输出：126 

 

 提示： 

 
 1 <= n == nums.length <= 2000 
 1 <= nums[i] <= 50 
 

 👍 2 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-08-13 20:53:57
 */
public class FindTheCountOfMonotonicPairsI{
    public static void main(String[] args) {
        Solution solution = new FindTheCountOfMonotonicPairsI().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int mod = 1_000_000_007;
    int[][] memo;
    public int countOfPairs(int[] nums) {
        int max = 0;
        int[] pre = new int[nums.length];
        int index= 0;
        int min = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
            pre[index++] = min;
        }
        memo = new int[nums.length][max + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return dfs(0,nums.length - 1,nums, pre);
    }
    public int dfs(int pre, int index, int[] nums, int[] a) {
        if (index < 0) {
            return 1;
        }
        if (memo[index][pre] != -1) {
            return memo[index][pre];
        }
        int result = 0;
        if (index == nums.length - 1) {
            for (int i = 0; i <= nums[index]; i++) {
                result = (result + dfs(i, index - 1, nums, a)) % mod;
            }
        } else {
            int max = pre - Math.max(0, nums[index + 1] - nums[index]);
            int min = Math.max(0, nums[index] - a[index]);
            for (int i = min; i <= max; i++) {
                result = (result + dfs(i, index - 1, nums, a)) % mod;
            }
        }
        memo[index][pre] = result;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}