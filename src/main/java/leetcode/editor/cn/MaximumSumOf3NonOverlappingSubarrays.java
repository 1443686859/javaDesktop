//给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且全部数字和（3 * k 项）最大的子数组，并返回这三个子数组。 
//
// 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,2,6,7,5,1], k = 2
//输出：[0,3,5]
//解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
//也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
//输出：[0,2,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] < 2¹⁶ 
// 1 <= k <= floor(nums.length / 3) 
// 
//
// Related Topics 数组 动态规划 👍 345 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-11-19 00:17:16
 */
public class MaximumSumOf3NonOverlappingSubarrays{
    public static void main(String[] args) {
        Solution solution = new MaximumSumOf3NonOverlappingSubarrays().new Solution();
//        System.out.println(solution.maxSumOfThreeSubarrays(new int[]{7,13,20,19,19,2,10,1,1,19}, 3));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] pre = new int[n];
        for (int i = 1; i < n - k; i++) {
            pre[i] = (sum[pre[i - 1] + k] - sum[pre[i - 1]] < sum[i + k] - sum[i]) ? i : pre[i - 1];

        }
        int[] after = new int[n];
        for (int i = n - k; i >= k - 1; i--) {
            after[i] = i == n - k ? i : (sum[after[i + 1] + k] - sum[after[i + 1]] <= sum[i + k] - sum[i] ? i : after[i + 1]);
        }
        int ans = 0;
        int[] result = new int[3];
        for (int i = k; i <= n - 2 * k; i++) {
            int currentPre = sum[pre[i - k] + k] - sum[pre[i - k]];
            int currentAfter = sum[after[i + k] + k] - sum[after[i + k]];
            int current = sum[i + k] - sum[i];
            if (ans < currentPre + current + currentAfter) {
                result = new int[]{pre[i - k], i, after[i + k]};
                ans = currentPre + current + currentAfter;
            }
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}