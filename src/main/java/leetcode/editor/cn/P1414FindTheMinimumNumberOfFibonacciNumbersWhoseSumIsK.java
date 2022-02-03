package leetcode.editor.cn;
//给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。 
//
// 斐波那契数字定义为： 
//
// 
// F1 = 1 
// F2 = 1 
// Fn = Fn-1 + Fn-2 ， 其中 n > 2 。 
// 
//
// 数据保证对于给定的 k ，一定能找到可行解。 
//
// 
//
// 示例 1： 
//
// 输入：k = 7
//输出：2 
//解释：斐波那契数字为：1，1，2，3，5，8，13，……
//对于 k = 7 ，我们可以得到 2 + 5 = 7 。 
//
// 示例 2： 
//
// 输入：k = 10
//输出：2 
//解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
// 
//
// 示例 3： 
//
// 输入：k = 19
//输出：3 
//解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 10^9 
// 
// Related Topics 贪心 👍 46 👎 0

import java.util.Arrays;

public class P1414FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinFibonacciNumbers(7));
    }
    // dp超时

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        /*    public int findMinFibonacciNumbers(int k) {
                int[] result = new int[45];
                result[0] = 1;
                result[1] = 1;
                int currentLength = 2;
                for (int i = 2; i < 45; i++) {
                    result[i] = result[i -1] + result[i - 2];
                    if (result[i] > k) {
                        break;
                    }
                    currentLength++;

                }
                int[] dp = new int[k + 1];
                Arrays.fill(dp, Integer.MAX_VALUE);
                dp[0] = 0;
                dp[1] = 1;
                for (int i = 2; i <= k; i++) {
                    for (int j = 0; j < currentLength; j++) {
                        if (i - result[j] >= 0) {
                            dp[i] = Math.min(dp[i], dp[i - result[j]] + 1);
                        }
                    }
                }
                return dp[k];
            }*/
        public int findMinFibonacciNumbers(int k) {
            int i = 1;
            int j = 1;
            int result = 0;
            while (k != 0) {
                int sum = i + j;
                if (sum > k) {
                    k -= j;
                    result++;
                    i = 1;
                    j = 1;
                } else {
                    i = j;
                    j = sum;
                }
                return result;
            }
        }


//leetcode submit region end(Prohibit modification and deletion)

    }
}