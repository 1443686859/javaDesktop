/**
如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。 

 给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。 

 

 示例 1： 

 
输入：n = 20
输出：19
解释：1 到 20 之间所有整数除了 11 以外都是特殊整数。所以总共有 19 个特殊整数。
 

 示例 2： 

 
输入：n = 5
输出：5
解释：1 到 5 所有整数都是特殊整数。
 

 示例 3： 

 
输入：n = 135
输出：110
解释：从 1 到 135 总共有 110 个整数是特殊整数。
不特殊的部分数字为：22 ，114 和 131 。 

 

 提示： 

 
 1 <= n <= 2 * 10⁹ 
 

 👍 120 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-09-20 20:15:52
 */
public class CountSpecialIntegers{
    public static void main(String[] args) {
        Solution solution = new CountSpecialIntegers().new Solution();
        System.out.println(solution.countSpecialNumbers(100));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] memo;
    public int countSpecialNumbers(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int max = 1 << 10;
        memo = new int[chars.length][max];
        for (int i = 0; i < chars.length; i++) {
            Arrays.fill(memo[i], - 1);
        }
        int result = count(true, 0, 0, chars, false);
        return result;
    }
    public int count(boolean isLimit, int mask, int index, char[] chars, boolean isNum) {
        if (index == chars.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && memo[index][mask] != -1) {
            return memo[index][mask];
        }
        int max = isLimit ? chars[index] - '0' : 9;
        int count = 0;
        for (int i = 0; i <= max; i++) {
            if ((mask & (1 << i)) == 0) {
                count += count(i == max && isLimit, (isNum || i != 0) ? (mask |1 << i) : mask, index + 1, chars, isNum || i != 0);
            }
        }
        if (!isLimit) {
            memo[index][mask] = count;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}