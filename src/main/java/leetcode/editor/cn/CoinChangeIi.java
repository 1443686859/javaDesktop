//给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。 
//
// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。 
//
// 假设每一种面额的硬币有无限个。 
//
// 题目数据保证结果符合 32 位带符号整数。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：amount = 5, coins = [1, 2, 5]
//输出：4
//解释：有四种方式可以凑成总金额：
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2： 
//
// 
//输入：amount = 3, coins = [2]
//输出：0
//解释：只用面额 2 的硬币不能凑成总金额 3 。
// 
//
// 示例 3： 
//
// 
//输入：amount = 10, coins = [10] 
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 300 
// 1 <= coins[i] <= 5000 
// coins 中的所有值 互不相同 
// 0 <= amount <= 5000 
// 
//
// Related Topics 数组 动态规划 👍 1267 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-03-25 20:33:33
 */
public class CoinChangeIi{
    public static void main(String[] args) {
        Solution solution = new CoinChangeIi().new Solution();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] result = new int[amount + 1];
        result[0] = 1;
        for (int i = 1 ;i <= n; i++) {
            int c = coins[i - 1];
            for (int j = c; j <= amount; j++) {

                    result[j] += result[j -c];

            }
        }
        return result[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}