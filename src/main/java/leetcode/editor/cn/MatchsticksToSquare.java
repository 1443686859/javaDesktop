//你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能
//折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。 
//
// 如果你能使这个正方形，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: matchsticks = [1,1,2,2,2]
//输出: true
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: matchsticks = [3,3,3,3,4]
//输出: false
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= matchsticks.length <= 15 
// 1 <= matchsticks[i] <= 10⁸ 
// 
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 359 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-06-01 19:01:27
 */
public class MatchsticksToSquare{
    public static void main(String[] args) {
        Solution solution = new MatchsticksToSquare().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (matchsticks.length < 4 || sum % 4 != 0) {
            return false;
        }
        int target = sum / 4;
        int n = matchsticks.length;
        for (int i : matchsticks) {
            if (i > target) {
                return false;
            }
        }
        return find(matchsticks, 4, target, (1<<n)- 1, 0, new Boolean[(1<<n)]);
    }

    private boolean find(int[] m, int num , int target, int limit, int sum, Boolean[] dp) {
        if (num == 0) {
            // 全部用完
            return limit == 0;
        }
        // 剩余的数limit
        if (dp[limit] != null) {
            return dp[limit];
        }
        int n = m.length;
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            // 当前i指向的元素可用
            if ((limit & mask) != 0) {
                int currentChoice = m[i];
                if (sum + currentChoice == target) {
                    // 刚好凑整
                    if (find(m, num - 1, target, limit - mask, 0, dp)) {
                        return true;
                    }
                } else if (sum + currentChoice < target) {
                    if (find(m, num, target, limit - mask, sum + currentChoice, dp)) {
                        return true;
                    }
                }
            }
        }
        dp[limit] = false;
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}