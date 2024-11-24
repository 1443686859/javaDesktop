//给你一个整数 k 和一个整数 x 。 
//
// 令 s 为整数 num 的下标从 1 开始的二进制表示。我们说一个整数 num 的 价值 是满足 i % x == 0 且 s[i] 是 设置位 的 i 
//的数目。 
//
// 请你返回 最大 整数 num ，满足从 1 到 num 的所有整数的 价值 和小于等于 k 。 
//
// 注意： 
//
// 
// 一个整数二进制表示下 设置位 是值为 1 的数位。 
// 一个整数的二进制表示下标从右到左编号，比方说如果 s == 11100 ，那么 s[4] == 1 且 s[2] == 0 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 9, x = 1
//输出：6
//解释：数字 1 ，2 ，3 ，4 ，5 和 6 二进制表示分别为 "1" ，"10" ，"11" ，"100" ，"101" 和 "110" 。
//由于 x 等于 1 ，每个数字的价值分别为所有设置位的数目。
//这些数字的所有设置位数目总数是 9 ，所以前 6 个数字的价值和为 9 。
//所以答案为 6 。 
//
// 示例 2： 
//
// 
//输入：k = 7, x = 2
//输出：9
//解释：由于 x 等于 2 ，我们检查每个数字的偶数位。
//2 和 3 在二进制表示下的第二个数位为设置位，所以它们的价值和为 2 。
//6 和 7 在二进制表示下的第二个数位为设置位，所以它们的价值和为 2 。
//8 和 9 在二进制表示下的第四个数位为设置位但第二个数位不是设置位，所以它们的价值和为 2 。
//数字 1 ，4 和 5 在二进制下偶数位都不是设置位，所以它们的价值和为 0 。
//10 在二进制表示下的第二个数位和第四个数位都是设置位，所以它的价值为 2 。
//前 9 个数字的价值和为 6 。
//前 10 个数字的价值和为 8，超过了 k = 7 ，所以答案为 9 。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 10¹⁵ 
// 1 <= x <= 8 
// 
//
// 👍 7 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-01-16 23:04:09
 */
public class MaximumNumberThatSumOfThePricesIsLessThanOrEqualToK{
    public static void main(String[] args) {
        Solution solution = new MaximumNumberThatSumOfThePricesIsLessThanOrEqualToK().new Solution();
        System.out.println(solution.findMaximumNumber(3278539330613L,5));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long findMaximumNumber(long k, int x) {
        long right = (k + 1) << x;
        this.k = x;
        long left = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (countDigitOne(mid) <= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
    long[][] memo;
    long num;
    int k;
    private long countDigitOne(long num) {
        this.num = num;
        int max = 64 - Long.numberOfLeadingZeros(num);
        memo = new long[max][max + 1];
        for (long[] m : memo) {
            Arrays.fill(m, -1);
        }
        return dfs(max - 1, 0, true);
    }
    private long dfs(int i, int cnt1, boolean isLimit) {
        if (i < 0) {
            return cnt1;
        }
        if (!isLimit && memo[i][cnt1] != -1) {
            return memo[i][cnt1];
        }
        int up = isLimit ? (int)(num >> i & 1) : 1;
        long result = 0;
        for (int d = 0; d <= up; d++) {
            result += dfs(i - 1, cnt1 + (d == 1 && (i + 1) % k == 0 ? 1 : 0), isLimit && d== up);
        }
        if (!isLimit) {
            memo[i][cnt1] = result;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}