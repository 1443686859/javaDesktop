//给你一个下标从 0 开始的整数数组 nums 和一个整数 threshold 。 
//
// 请你从 nums 的子数组中找出以下标 l 开头、下标 r 结尾 (0 <= l <= r < nums.length) 且满足以下条件的 最长子数组 ：
// 
//
// 
// nums[l] % 2 == 0 
// 对于范围 [l, r - 1] 内的所有下标 i ，nums[i] % 2 != nums[i + 1] % 2 
// 对于范围 [l, r] 内的所有下标 i ，nums[i] <= threshold 
// 
//
// 以整数形式返回满足题目要求的最长子数组的长度。 
//
// 注意：子数组 是数组中的一个连续非空元素序列。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,2,5,4], threshold = 5
//输出：3
//解释：在这个示例中，我们选择从 l = 1 开始、到 r = 3 结束的子数组 => [2,5,4] ，满足上述条件。
//因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。 
//
// 示例 2： 
//
// 输入：nums = [1,2], threshold = 2
//输出：1
//解释：
//在这个示例中，我们选择从 l = 1 开始、到 r = 1 结束的子数组 => [2] 。
//该子数组满足上述全部条件。可以证明 1 是满足题目要求的最大长度。
// 
//
// 示例 3： 
//
// 输入：nums = [2,3,4,5], threshold = 4
//输出：3
//解释：
//在这个示例中，我们选择从 l = 0 开始、到 r = 2 结束的子数组 => [2,3,4] 。 
//该子数组满足上述全部条件。
//因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 1 <= threshold <= 100 
// 
//
// Related Topics 数组 滑动窗口 👍 72 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-11-16 22:23:04
 */
public class LongestEvenOddSubarrayWithThreshold{
    public static void main(String[] args) {
        Solution solution = new LongestEvenOddSubarrayWithThreshold().new Solution();
        System.out.println(solution.longestAlternatingSubarray(new int[]{8,4}, 6));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int left = 0;
        int right = 0;
        int result = 0;
        int pre1 = -1;
        int pre2 = -1;
        while (right < nums.length) {
            while (left < nums.length && ((nums[left] & 1) != 0 || left <= pre1 || left < pre2)) {
                left ++;
            }
            if (nums[right] > threshold) {
                pre1 = right;
            } else if ( (right >= 1 && right - 1 >= left && ((nums[right - 1] ^ nums[right]) & 1) == 0)) {
                pre2 = right;
            } else {

                result = Math.max(result, right - left + 1);
            }
            right++;
        }
        while (left < nums.length && ((nums[left] & 1) != 0 ||left <= pre1 || left < pre2)) {
            left ++;
        }
        return Math.max(result, right - left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}