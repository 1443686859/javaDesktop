package leetcode.editor.cn;
//给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。 
//
// 返回 nums 中 所有 子数组范围的 和 。 
//
// 子数组是数组中一个连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3]
//输出：4
//解释：nums 的 6 个子数组如下所示：
//[1]，范围 = 最大 - 最小 = 1 - 1 = 0 
//[2]，范围 = 2 - 2 = 0
//[3]，范围 = 3 - 3 = 0
//[1,2]，范围 = 2 - 1 = 1
//[2,3]，范围 = 3 - 2 = 1
//[1,2,3]，范围 = 3 - 1 = 2
//所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4 
//
// 示例 2： 
//
// 输入：nums = [1,3,3]
//输出：4
//解释：nums 的 6 个子数组如下所示：
//[1]，范围 = 最大 - 最小 = 1 - 1 = 0
//[3]，范围 = 3 - 3 = 0
//[3]，范围 = 3 - 3 = 0
//[1,3]，范围 = 3 - 1 = 2
//[3,3]，范围 = 3 - 3 = 0
//[1,3,3]，范围 = 3 - 1 = 2
//所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4
// 
//
// 示例 3： 
//
// 输入：nums = [4,-2,-3,4,1]
//输出：59
//解释：nums 中所有子数组范围的和是 59
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// 👍 8 👎 0

public class P2104SumOfSubarrayRanges{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long subArrayRanges(int[] nums) {
    /*    long result = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                result += max - min;
            }
        }
        return result;*/
        int left = 0;
        int right = 0;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            left = i;
            right = i;
            while (left - 1 >= 0 && nums[left - 1] < nums[i]) {
                left--;
            }
            while (right + 1 < nums.length && nums[right + 1] <= nums[i]) {
                right++;
            }
            // nums[i]作为区间的最大值
            ans += (long)nums[i] * (right -i + 1) * (i - left + 1);

            left = i;
            right = i;
            while (left - 1 >= 0 && nums[left - 1] > nums[i]) {
                left--;
            }
            while (right + 1 < nums.length && nums[right + 1] >= nums[i]) {
                right++;
            }
            // nums[i]作为区间的最小值
            ans -= (long)nums[i] * (right -i + 1) * (i - left + 1);

        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}