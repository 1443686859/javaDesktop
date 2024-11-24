//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2060 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-07-28 19:07:05
 */
public class CoinChange{
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
//        System.out.println(solution.coinChange(new int[]{2,5,10,1}, 27));
//        System.out.println(solution.maximumLengthSubstring("bdbbabccad"));
//        System.out.println(solution.minOperations(11));
        System.out.println(solution.mostFrequentIDs(new int[]{2,3,2,1}, new int[]{3,2,-3,1}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int c : coins) {
            for (int j = c; j <= amount; j++) {
                if (dp[j - c] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - c] + 1);
                }
            }
        }

        return dp[amount] >= Integer.MAX_VALUE / 2 ? - 1: dp[amount];
    }
    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < s.length()) {
            int index = s.charAt(right) - 'a';
            count[index]++;
            while (left <= right && count[index] > 2) {
                int leftIndex = s.charAt(left) - 'a';
                count[leftIndex]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
    public int minOperations(int k) {
        if (k <= 1) {
            return 0;
        }
        int base = (int)Math.sqrt(k);
        return (base - 1) + ((k + base - 1)/ base) - 1;
    }
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        long[] count = new long[max + 1];
        long[] base = new long[max + 1];
        long[] ans = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            update(base, count, nums[i], base[nums[i]] + freq[i]);
            ans[i] = get(count);
        }
        return ans;
    }
    public int lowbit(int x) {
        return x & -x;
    }
    public void update(long[] arr, long[] max, int start, long current) {
        int index = start;
        arr[index] = current;
        max[index] = current;
        while (index < arr.length) {
            int lowBit = lowbit(index);
            max[index] = arr[index];
            for (int j = 1; j <= lowBit; j <<= 1) {
                max[index] = Math.max(max[index], max[index - j]);
            }
            index += lowBit;
        }
    }
    public long get(long[] max) {
        int index = max.length - 1;
        long ans = 0;
        while (index >= 1) {
            ans = Math.max(ans, max[index]);
            index -= lowbit(index);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}