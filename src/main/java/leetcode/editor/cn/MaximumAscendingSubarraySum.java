//给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。 
//
// 子数组是数组中的一个连续数字序列。 
//
// 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < 
//numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,20,30,5,10,50]
//输出：65
//解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [10,20,30,40,50]
//输出：150
//解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。 
// 
//
// 示例 3： 
//
// 
//输入：nums = [12,17,15,13,10,11,12]
//输出：33
//解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。 
// 
//
// 示例 4： 
//
// 
//输入：nums = [100,10,1]
//输出：100
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 👍 48 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-10-07 09:16:41
 */
public class MaximumAscendingSubarraySum{
    public static void main(String[] args) {
        Solution solution = new MaximumAscendingSubarraySum().new Solution();
        System.out.println(solution.maxAscendingSum(new int[]{100,10,1}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        int max = nums[0];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = nums[i] + sum[i - 1];
            max = Math.max(max, nums[i]);
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                int preIndex = i - 1 - count - 1;
                int target = 0;
                if (preIndex != -1) {
                    target = sum[preIndex];
                }
                max = Math.max(max, sum[i - 1] - target);
                count = 0;
            } else {
                count++;
            }
        }
        if (count != 0) {
            int preIndex = n - 1 - count - 1;
            int target = 0;
            if (preIndex != -1) {
                target = sum[preIndex];
            }
            max = Math.max(max, sum[n - 1] - target);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}