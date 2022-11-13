//给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。 
//
// 如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分： 
//
// 
// 子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。 
// 子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。 
// 子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。 
// 
//
// 如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,4,4,5,6]
//输出：true
//解释：数组可以划分成子数组 [4,4] 和 [4,5,6] 。
//这是一种有效划分，所以返回 true 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,2]
//输出：false
//解释：该数组不存在有效划分。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 数组 动态规划 👍 19 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-08-12 23:13:06
 */
public class CheckIfThereIsAValidPartitionForTheArray{
    public static void main(String[] args) {
        Solution solution = new CheckIfThereIsAValidPartitionForTheArray().new Solution();
        System.out.println(solution.validPartition(new int[]{4,4,4,5,6}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] result  = new boolean[n + 1];
        result[0] = true;
        result[1] = false;
        for (int i = 2; i < n; i++) {
            int pre = nums[i - 2];
            int current = nums[i - 1];
            int after = nums[i];
            if (pre == current) {
                result[i] = result[i - 2];
            }
            if (pre == current && current == after) {
                result[i + 1] = result[i - 2];
            }
            if (current - pre == 1 && after - current == 1) {
                result[i + 1] = result[i - 2];
            }
        }
        return result[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}