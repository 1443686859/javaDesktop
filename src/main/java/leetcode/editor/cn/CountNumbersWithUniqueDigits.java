//给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10ⁿ 。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：91
//解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。 
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：1
// 
// 
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 数学 动态规划 回溯 👍 263 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-04-11 22:05:15
 */
public class CountNumbersWithUniqueDigits{
    public static void main(String[] args) {
        Solution solution = new CountNumbersWithUniqueDigits().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int[] count = new int[n + 1];
        count[1] = 10;
        for (int i = 2; i <= n; i++) {
            count[i] = count[i - 1] + 9 * (get(9) / get(10 - i));
        }
        return count[n];
    }
    public int get(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * get(n - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}