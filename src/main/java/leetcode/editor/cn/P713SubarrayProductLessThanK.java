package leetcode.editor.cn;
//给定一个正整数数组 nums和整数 k 。 
//
// 请找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3], k = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
// Related Topics 数组 滑动窗口 👍 335 👎 0

public class P713SubarrayProductLessThanK{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10,3,3,7,2,9,7,4,7,2,8,6,5,1,5}, 30));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        double[] preList = new double[n + 1];
        preList[0] = 1;
        // 区间积 使用log转化
        for (int i =0; i < n; i++) {
            preList[i + 1] = preList[i] + Math.log(nums[i]);
        }
        double target = Math.log(k);
        int ans = 0;
        int[] ansList = new int[n];
        for (int i = 0; i < n; i++) {
            int l0 = i + 1;
            int r = n;
            while (l0 <= r) {
                int mid = (l0 + r) / 2;
                // 使用绝对值小于 一个特别小的数来认证是否相等
                if (preList[mid] - preList[i] >= target || Math.abs(preList[mid] - preList[i] - target) <= 1e-9) {
                    r = mid - 1;
                } else {
                    l0 = mid + 1;
                }
            }
            ansList[i] = l0 - 1 - i;
            ans += l0 - 1 - i;
        }
        return ans;
    }
    public int numSubarrayProductLesThanK(int[] nums, int k) {
        if (k <= 0) {
            return 0;
        }
        int n = nums.length;
        int current = 1;
        int left = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            current *= nums[i];
            while (current >= k) {
                current /= nums[left++];
            }
            ans += i - left + 1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}