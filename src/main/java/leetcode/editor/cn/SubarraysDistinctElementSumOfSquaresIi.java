//给你一个下标从 0 开始的整数数组 nums 。 
//
// 定义 nums 一个子数组的 不同计数 值如下： 
//
// 
// 令 nums[i..j] 表示 nums 中所有下标在 i 到 j 范围内的元素构成的子数组（满足 0 <= i <= j < nums.length ）
//，那么我们称子数组 nums[i..j] 中不同值的数目为 nums[i..j] 的不同计数。 
// 
//
// 请你返回 nums 中所有子数组的 不同计数 的 平方 和。 
//
// 由于答案可能会很大，请你将它对 10⁹ + 7 取余 后返回。 
//
// 子数组指的是一个数组里面一段连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1]
//输出：15
//解释：六个子数组分别为：
//[1]: 1 个互不相同的元素。
//[2]: 1 个互不相同的元素。
//[1]: 1 个互不相同的元素。
//[1,2]: 2 个互不相同的元素。
//[2,1]: 2 个互不相同的元素。
//[1,2,1]: 2 个互不相同的元素。
//所有不同计数的平方和为 1² + 1² + 1² + 2² + 2² + 2² = 15 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2]
//输出：3
//解释：三个子数组分别为：
//[2]: 1 个互不相同的元素。
//[2]: 1 个互不相同的元素。
//[2,2]: 1 个互不相同的元素。
//所有不同计数的平方和为 1² + 1² + 1² = 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 树状数组 线段树 数组 动态规划 👍 8 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-11-02 23:46:44
 */
public class SubarraysDistinctElementSumOfSquaresIi{
    public static void main(String[] args) {
        Solution solution = new SubarraysDistinctElementSumOfSquaresIi().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumCounts(int[] nums) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}