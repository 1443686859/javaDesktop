//给你一个下标从 0 开始的整数数组 coins，表示可用的硬币的面值，以及一个整数 target 。 
//
// 如果存在某个 coins 的子序列总和为 x，那么整数 x 就是一个 可取得的金额 。 
//
// 返回需要添加到数组中的 任意面值 硬币的 最小数量 ，使范围 [1, target] 内的每个整数都属于 可取得的金额 。 
//
// 数组的 子序列 是通过删除原始数组的一些（可能不删除）元素而形成的新的 非空 数组，删除过程不会改变剩余元素的相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1,4,10], target = 19
//输出：2
//解释：需要添加面值为 2 和 8 的硬币各一枚，得到硬币数组 [1,2,4,8,10] 。
//可以证明从 1 到 19 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 2 。
// 
//
// 示例 2： 
//
// 
//输入：coins = [1,4,10,5,7,19], target = 19
//输出：1
//解释：只需要添加一枚面值为 2 的硬币，得到硬币数组 [1,2,4,5,7,10,19] 。
//可以证明从 1 到 19 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 1 。 
//
// 示例 3： 
//
// 
//输入：coins = [1,1,1], target = 20
//输出：3
//解释：
//需要添加面值为 4 、8 和 16 的硬币各一枚，得到硬币数组 [1,1,1,4,8,16] 。 
//可以证明从 1 到 20 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 3 。 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁵ 
// 1 <= coins.length <= 10⁵ 
// 1 <= coins[i] <= target 
// 
//
// Related Topics 贪心 数组 排序 👍 63 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-03-30 12:07:32
 */
public class MinimumNumberOfCoinsToBeAdded{
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfCoinsToBeAdded().new Solution();
//        System.out.println(solution.minimumLevels(new int[]{1,0,1,0}));
//        System.out.println(solution.minimumSubarrayLength(new int[]{1,2,3}, 2));
        System.out.println(solution.sumOfPowers(new int[]{1,2,3,4}, 3));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int start = 0;
        int index = 0;
        int result = 0;
        while (start < target) {
            if (index < coins.length && (coins[index] <= start + 1)) {
                start += coins[index];
                index++;
            } else {
                result++;
                start += start + 1;
            }
        }
        return result;
    }
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (possible[i] == 0 ? -1 : 1);
        }
        int result = -1;
        for (int i = 0; i < n; i++) {
            if (sum[i + 1] > sum[n] - sum[i + 1]) {
                result = i;
                break;
            }
        }
        return result != -1 && result != n - 1 ? result + 1 : - 1;
    }
    public int minimumSubarrayLength(int[] nums, int k) {
        int left = -1;
        int right = 0;
        int n = nums.length;
        int[] count = new int[32];
        int result = Integer.MAX_VALUE;
        while (right < n) {
            add(count, nums[right]);
            while (left < right && check(count, k)) {
                result = Math.min(result, right - left);
                minus(count, nums[++left]);
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? - 1: result;
    }
    public void add(int[] count, int target) {
        int base = count.length - 1;
        while (target > 0) {
            if ((target & 1) == 1) {
                count[base]++;
            }
            target >>= 1;
            base --;
        }
    }
    public void minus(int[] count, int target) {
        int base = count.length - 1;
        while (target > 0) {
            if ((target & 1) == 1) {
                count[base]--;
            }
            target >>= 1;
            base --;
        }
    }
    public boolean check(int[] count, int k) {
        int target = 0;
        int index = count.length - 1;
        int base = 1;
        while (index >= 0) {
            if (count[index] > 0) {
                target |= base;
            }
            base <<= 1;
            index--;
        }
        return target >= k;
    }
    int mod = 1_000_000_007;
    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            result += dfs(nums, -1, k, i);
        }
        return result;
    }
    public int dfs(int[] nums, int pre, int rest, int index) {
        if (rest > nums.length - index || rest == 0) {
            return Integer.MAX_VALUE;
        }
        int base = pre != -1 ? nums[index] - nums[pre] : Integer.MAX_VALUE;
        for (int i = index + 1; i <= nums.length - rest; i++) {
            base = Math.min(base, dfs(nums, index, rest - 1, i));
        }
        return base;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}