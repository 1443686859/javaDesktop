//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
//
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 782 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-09-20 20:28:38
 */
public class PartitionToKEqualSumSubsets{
    public static void main(String[] args) {
        Solution solution = new PartitionToKEqualSumSubsets().new Solution();
        System.out.println(solution.canPartitionKSubsets(new int[]{605,454,322,218,8,19,651,2220,175,710,2666,350,252,2264,327,1843}, 4));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int target;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        target = sum / k;
        int n = nums.length;
        boolean[] used = new boolean[1 << n];
        Arrays.fill(used, true);
        return dfs((1 << n) - 1, 0, used, nums);
    }
    public boolean dfs(int current, int sum, boolean[] used, int[] nums) {
        if (current == 0) {
            return true;
        }
        if (!used[current]) {
            return used[current];
        }
        used[current] = false;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                break;
            }
            if ((current >> i & 1) != 0) {
                if (dfs(current ^ (1 << i), (sum + nums[i]) % target, used, nums)) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}