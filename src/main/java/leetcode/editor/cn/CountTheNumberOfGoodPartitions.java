/**
给你一个下标从 0 开始、由 正整数 组成的数组 nums。 

 将数组分割成一个或多个 连续 子数组，如果不存在包含了相同数字的两个子数组，则认为是一种 好分割方案 。 

 返回 nums 的 好分割方案 的 数目。 

 由于答案可能很大，请返回答案对 10⁹ + 7 取余 的结果。 

 

 示例 1： 

 
输入：nums = [1,2,3,4]
输出：8
解释：有 8 种 好分割方案 ：([1], [2], [3], [4]), ([1], [2], [3,4]), ([1], [2,3], [4]), ([1]
, [2,3,4]), ([1,2], [3], [4]), ([1,2], [3,4]), ([1,2,3], [4]) 和 ([1,2,3,4]) 。
 

 示例 2： 

 
输入：nums = [1,1,1,1]
输出：1
解释：唯一的 好分割方案 是：([1,1,1,1]) 。
 

 示例 3： 

 
输入：nums = [1,2,1,3]
输出：2
解释：有 2 种 好分割方案 ：([1,2,1], [3]) 和 ([1,2,1,3]) 。
 

 

 提示： 

 
 1 <= nums.length <= 10⁵ 
 1 <= nums[i] <= 10⁹ 
 

 👍 14 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-07-27 03:41:25
 */
public class CountTheNumberOfGoodPartitions{
    public static void main(String[] args) {
        Solution solution = new CountTheNumberOfGoodPartitions().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}