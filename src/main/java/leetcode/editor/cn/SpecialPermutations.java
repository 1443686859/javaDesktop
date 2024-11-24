/**
给你一个下标从 0 开始的整数数组 nums ，它包含 n 个 互不相同 的正整数。如果 nums 的一个排列满足以下条件，我们称它是一个特别的排列： 

 
 对于 0 <= i < n - 1 的下标 i ，要么 nums[i] % nums[i+1] == 0 ，要么 nums[i+1] % nums[i] ==
 0 。 
 

 请你返回特别排列的总数目，由于答案可能很大，请将它对 109 + 7 取余 后返回。 

 

 示例 1： 

 输入：nums = [2,3,6]
输出：2
解释：[3,6,2] 和 [2,6,3] 是 nums 两个特别的排列。
 

 示例 2： 

 输入：nums = [1,4,3]
输出：2
解释：[3,1,4] 和 [4,1,3] 是 nums 两个特别的排列。
 

 

 提示： 

 
 2 <= nums.length <= 14 
 1 <= nums[i] <= 10⁹ 
 

 👍 73 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-06-26 22:28:43
 */
public class SpecialPermutations{
    public static void main(String[] args) {
        Solution solution = new SpecialPermutations().new Solution();
        System.out.println(solution.specialPerm(new int[]{1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8191}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] memo;
        int mod = 1_000_000_007;
    public int specialPerm(int[] nums) {
        int n = nums.length;
        memo = new int[n][(1 << n) - 1];
        for (int[] m : memo) {
            Arrays.fill(m, Integer.MAX_VALUE / 2);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int base = get(nums, i, 1 << i);
            if (base != -1) {
                result = (result + base) % mod;
            }
        }
        return result;
    }
    public int get(int[] nums, int pre, int mask) {
        if (mask == (1 << nums.length) - 1) {
            return 1;
        }
        if (memo[pre][mask] != Integer.MAX_VALUE / 2) {
            return memo[pre][mask];
        }
        int count = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) == 0 && (nums[i] % nums[pre] == 0 || nums[pre] % nums[i] == 0)) {
                int base = get(nums, i, mask | 1 << i);
                if (base != -1) {
                    result = (result + base) % mod;
                    count++;
                }
            }
        }
        if (count == 0) {
            memo[pre][mask] = -1;
            return -1;
        }
        memo[pre][mask] = result;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}