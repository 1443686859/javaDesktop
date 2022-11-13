//给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。 
//
// 请你计算并返回该式的最大值。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,5,2]
//输出：12 
//解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) =
// 3*4 = 12 。 
// 
//
// 示例 2： 
//
// 输入：nums = [1,5,4,5]
//输出：16
//解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
// 
//
// 示例 3： 
//
// 输入：nums = [3,7]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 500 
// 1 <= nums[i] <= 10^3 
// 
//
// Related Topics 数组 排序 堆（优先队列） 👍 75 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-08-26 19:59:19
 */
public class MaximumProductOfTwoElementsInAnArray{
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfTwoElementsInAnArray().new Solution();
        System.out.println(solution.maxProduct(new int[]{3,4,5,2}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int max = -1;
        int second = -1;
        for (int i : nums) {
            if (i > max) {
                second = max;
                max = i;
            } else if (i > second) {
                second = i;
            }
        }
        return (second - 1) * (max - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}