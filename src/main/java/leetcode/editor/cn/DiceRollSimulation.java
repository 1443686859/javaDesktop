//有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。 
//
// 不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。 
//
// 现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。 
//
// 假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, rollMax = [1,1,2,2,2,3]
//输出：34
//解释：我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所
//以不会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2 = 34。
// 
//
// 示例 2： 
//
// 输入：n = 2, rollMax = [1,1,1,1,1,1]
//输出：30
// 
//
// 示例 3： 
//
// 输入：n = 3, rollMax = [1,1,1,2,2,3]
//输出：181
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5000 
// rollMax.length == 6 
// 1 <= rollMax[i] <= 15 
// 
//
// Related Topics 数组 动态规划 👍 190 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-02-10 21:49:07
 */
public class DiceRollSimulation{
    public static void main(String[] args) {
        Solution solution = new DiceRollSimulation().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int mod = (int)1e9 + 7;
        int m = rollMax.length;
        int[][] result = new int[n][m];
        int[] ans = new int[n];
        Arrays.fill(result[0], 1);
        ans[0] = m;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j ++) {
                int currentResult = ans[i - 1];
                int count = rollMax[j];
                if (i > count) {
                    currentResult -= ans[i - count - 1] - result[i - count - 1][j];
                } else if (i == count) {
                    currentResult--;
                }
                result[i][j] = (currentResult % mod + mod) % mod;
                ans[i] = (ans[i] + result[i][j]) % mod;
            }
        }
        return ans[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}