//这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。 
//
// 给定三个整数 n , k 和 target ，返回可能的方式(从总共 kⁿ 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。 
//
// 答案可能很大，你需要对 10⁹ + 7 取模 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1, k = 6, target = 3
//输出：1
//解释：你扔一个有 6 个面的骰子。
//得到 3 的和只有一种方法。
// 
//
// 示例 2： 
//
// 
//输入：n = 2, k = 6, target = 7
//输出：6
//解释：你扔两个骰子，每个骰子有 6 个面。
//得到 7 的和有 6 种方法：1+6 2+5 3+4 4+3 5+2 6+1。
// 
//
// 示例 3： 
//
// 
//输入：n = 30, k = 30, target = 500
//输出：222616187
//解释：返回的结果必须是对 10⁹ + 7 取模。 
//
// 
//
// 提示： 
//
// 
// 1 <= n, k <= 30 
// 1 <= target <= 1000 
// 
//
// Related Topics 动态规划 👍 178 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-10-24 01:04:56
 */
public class NumberOfDiceRollsWithTargetSum{
    public static void main(String[] args) {
        Solution solution = new NumberOfDiceRollsWithTargetSum().new Solution();
        System.out.println(solution.numRollsToTarget(4,6,10));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int MOD = (int)1e9 + 7;
        long[] result = new long[target - n + 1];
        result[0] = 1;
        for (int i = 1; i <= n; i++) {
            int max = Math.min(i * (k - 1), target - n);
            for (int j = 1; j <= max; j++) {
                result[j] = (result[j - 1] + result[j]) ;
            }
            for (int j = max; j >= k; j --) {
                result[j] = (result[j] - result[j - k]) % MOD;
            }
        }
        return (int)result[target - n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}