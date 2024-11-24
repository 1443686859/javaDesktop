/**
给你一个数组 nums 和一个整数 k 。你需要找到 nums 的一个 子数组 ，满足子数组中所有元素按位与运算 AND 的值与 k 的 绝对差 尽可能 小 。
换言之，你需要选择一个子数组 nums[l..r] 满足 |k - (nums[l] AND nums[l + 1] ... AND nums[r])| 最小。
 

 请你返回 最小 的绝对差值。 

 子数组是数组中连续的 非空 元素序列。 

 

 示例 1： 

 
 输入：nums = [1,2,4,5], k = 3 
 

 输出：1 

 解释： 

 子数组 nums[2..3] 的按位 AND 运算值为 4 ，得到最小差值 |3 - 4| = 1 。 

 示例 2： 

 
 输入：nums = [1,2,1,2], k = 2 
 

 输出：0 

 解释： 

 子数组 nums[1..1] 的按位 AND 运算值为 2 ，得到最小差值 |2 - 2| = 0 。 

 示例 3： 

 
 输入：nums = [1], k = 10 
 

 输出：9 

 解释： 

 只有一个子数组，按位 AND 运算值为 1 ，得到最小差值 |10 - 1| = 9 。 

 

 提示： 

 
 1 <= nums.length <= 10⁵ 
 1 <= nums[i] <= 10⁹ 
 1 <= k <= 10⁹ 
 

 👍 6 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-06-04 21:02:49
 */
public class FindSubarrayWithBitwiseAndClosestToK{
    public static void main(String[] args) {
        Solution solution = new FindSubarrayWithBitwiseAndClosestToK().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDifference(int[] nums, int k) {
       int ans = Integer.MAX_VALUE;
       for (int i = 0; i < nums.length; i++) {
           ans = Math.min(ans, Math.abs(nums[i] - k));
           for (int j = i - 1; j >= 0 && (nums[j] & nums[i]) != nums[j]; j--) {
               nums[j] &= nums[i];
               ans = Math.min(ans, Math.abs(nums[j] - k));
           }
       }
       return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}