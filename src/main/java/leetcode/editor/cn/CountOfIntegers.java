//给你两个数字字符串 num1 和 num2 ，以及两个整数 max_sum 和 min_sum 。如果一个整数 x 满足以下条件，我们称它是一个好整数： 
//
// 
// num1 <= x <= num2 
// min_sum <= digit_sum(x) <= max_sum. 
// 
//
// 请你返回好整数的数目。答案可能很大，请返回答案对 10⁹ + 7 取余后的结果。 
//
// 注意，digit_sum(x) 表示 x 各位数字之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "1", num2 = "12", min_num = 1, max_num = 8
//输出：11
//解释：总共有 11 个整数的数位和在 1 到 8 之间，分别是 1,2,3,4,5,6,7,8,10,11 和 12 。所以我们返回 11 。
// 
//
// 示例 2： 
//
// 
//输入：num1 = "1", num2 = "5", min_num = 1, max_num = 5
//输出：5
//解释：数位和在 1 到 5 之间的 5 个整数分别为 1,2,3,4 和 5 。所以我们返回 5 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1 <= num2 <= 10²² 
// 1 <= min_sum <= max_sum <= 400 
// 
//
// Related Topics 数学 字符串 动态规划 👍 76 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-01-16 20:27:17
 */
public class CountOfIntegers{
    public static void main(String[] args) {
        Solution solution = new CountOfIntegers().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int mod = 1_000_000_007;
        int max;
        int min;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        min = min_sum;
        max = max_sum;
        int result = (count(num2) - count(num1) + mod);
        int sum = 0;
        for (int i = 0; i < num1.length(); i++) {
            sum += num1.charAt(i) - '0';
        }
        if (sum >= min && sum <= max) {
            result ++;
        }
        return result % mod;
    }
    public int count(String n) {
        int l = n.length();
        int[][] memo = new int[l][Math.min(9 * l, max) + 1];
        for (int i = 0; i < l; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(memo, n, 0, 0, true);
    }
    public int dfs(int[][] memo,String num, int index, int sum, boolean isLimit) {
        if (sum > max) {
            return 0;
        }
        if (index == memo.length) {
            return sum >= min ? 1 : 0;
        }
        if (!isLimit && memo[index][sum] != -1) {
            return memo[index][sum];
        }
        int maxCount = isLimit ? num.charAt(index) - '0' : 9;
        int result = 0;
        for (int i = 0; i <= maxCount; i++) {
            result = (result + dfs(memo, num, index + 1, sum + i, isLimit && i == maxCount)) % mod;
        }
        if (!isLimit) {
            memo[index][sum] = result;
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}