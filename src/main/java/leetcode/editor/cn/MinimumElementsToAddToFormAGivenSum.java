//给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。 
//
// 返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
// 
//
// 注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-1,1], limit = 3, goal = -4
//输出：2
//解释：可以将 -2 和 -3 添加到数组中，数组的元素总和变为 1 - 1 + 1 - 2 - 3 = -4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,-10,9,1], limit = 100, goal = 0
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= limit <= 10⁶ 
// -limit <= nums[i] <= limit 
// -10⁹ <= goal <= 10⁹ 
// 
//
// Related Topics 贪心 数组 👍 43 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-12-16 20:16:16
 */
public class MinimumElementsToAddToFormAGivenSum{
    public static void main(String[] args) {
        Solution solution = new MinimumElementsToAddToFormAGivenSum().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return  (int)(Math.abs(goal - sum) / limit + (Math.abs(goal - sum) % limit != 0 ? 1 : 0));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}