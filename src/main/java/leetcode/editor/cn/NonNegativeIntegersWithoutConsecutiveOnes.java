/**
给定一个正整数 n ，请你统计在 [0, n] 范围的非负整数中，有多少个整数的二进制表示中不存在 连续的 1 。 

 

 示例 1: 

 
输入: n = 5
输出: 5
解释: 
下面列出范围在 [0, 5] 的非负整数与其对应的二进制表示：
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
其中，只有整数 3 违反规则（有两个连续的 1 ），其他 5 个满足规则。 

 示例 2: 

 
输入: n = 1
输出: 2
 

 示例 3: 

 
输入: n = 2
输出: 3
 

 

 提示: 

 
 1 <= n <= 10⁹ 
 

 👍 385 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-08-05 20:14:26
 */
public class NonNegativeIntegersWithoutConsecutiveOnes{
    public static void main(String[] args) {
        Solution solution = new NonNegativeIntegersWithoutConsecutiveOnes().new Solution();
        System.out.println(solution.findIntegers(4));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] dp;
    public int findIntegers(int n) {
        dp = new int[Integer.SIZE - Integer.numberOfLeadingZeros(n)][2];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return dfs(n,  Integer.SIZE - Integer.numberOfLeadingZeros(n) - 1, 0, true);
    }
    public int dfs(int s, int index, int pre, boolean isLimit) {
        if (index < 0) {
            return 1;
        }
        if (!isLimit && dp[index][pre] != -1) {
            return dp[index][pre];
        }
        int up = isLimit ? (s >> index) & 1 : 1;
        int result = dfs(s, index - 1, 0, isLimit && up == 0);
        if (pre == 0 && up == 1) {
            result += dfs(s, index - 1, 1, isLimit);
        }
        if (!isLimit) {
            dp[index][pre] = result;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}