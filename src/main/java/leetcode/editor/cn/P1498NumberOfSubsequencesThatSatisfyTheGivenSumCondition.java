package leetcode.editor.cn;
//给你一个整数数组 nums 和一个整数 target 。 
//
// 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。 
//
// 由于答案可能很大，请将结果对 10^9 + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,5,6,7], target = 9
//输出：4
//解释：有 4 个子序列满足该条件。
//[3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
//[3,5] -> (3 + 5 <= 9)
//[3,5,6] -> (3 + 6 <= 9)
//[3,6] -> (3 + 6 <= 9)
// 
//
// 示例 2： 
//
// 输入：nums = [3,3,6,8], target = 10
//输出：6
//解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
//[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6] 
//
// 示例 3： 
//
// 输入：nums = [2,3,3,4,6,7], target = 12
//输出：61
//解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
//有效序列总数为（63 - 2 = 61）
// 
//
// 示例 4： 
//
// 输入：nums = [5,2,4,1,7,6,8], target = 16
//输出：127
//解释：所有非空子序列都满足条件 (2^7 - 1) = 127 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 1 <= target <= 10^6 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 80 👎 0

import java.util.Arrays;

public class P1498NumberOfSubsequencesThatSatisfyTheGivenSumCondition{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubseq(new int[]{9,25,9,28,24,12,17,8,28,7,21,25,10,2,16,19,12,13,15,28,14,12,24,9,6,7,2,15,19,13,30,30,23,19,11,3,17,2,14,20,22,30,12,1,11,2,2,20,20,27,15,9,10,4,12,30,13,5,2,11,29,5,3,13,22,5,16,19,7,19,11,16,11,25,29,21,29,3,2,9,20,15,9},32));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    int mod = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        long result = 0;
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++){
            pow[i] = (pow[i-1] << 1) % mod;
        }
        for (int i = 0; i < n; i++) {
            int maxValue = target - nums[i];
            if (maxValue < nums[i]) {
                continue;
            }
            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                int num = nums[mid];
                if (num <= maxValue) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            result = (result + pow[l - i - 1] % mod) % mod;
        }
        return (int)result;
    }
    public int fastPow( int pow) {
        long result = 1;
        long current = 2;
        while (pow != 0) {
            if ((pow & 1) == 1) {
                result = (result % mod * current % mod) % mod;
            }
            current = current % mod * (current % mod);
            pow >>= 1;
        }
        return (int)result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}