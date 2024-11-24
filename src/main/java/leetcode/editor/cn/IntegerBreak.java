//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
//
// Related Topics 数学 动态规划 👍 1032 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-01-31 21:10:55
 */
public class IntegerBreak{
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();
        System.out.println(solution.integerBreak(8));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] count;
    public int integerBreak(int n) {
        count = new int[n + 1];
        return getResult(n);
    }
     public int getResult(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
                return 1;
            }

        if (count[n] != 0) {
            return count[n];
        }
        int next = n / 2;
        int result = 0;
        for (int i = 1; i <= next; i++) {
            int dNext = getResult(i);
            int dNNext = getResult(n - i);
            result = Math.max(result, Math.max(dNext, i) * Math.max(dNNext, n - i));
        }
        count[n] = result; // 从此开始進行拆分
        return count[n];
     }
}
//leetcode submit region end(Prohibit modification and deletion)

}