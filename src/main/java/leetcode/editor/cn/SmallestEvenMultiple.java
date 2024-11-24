//给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
//
// 
//
// 示例 1： 
//
// 输入：n = 5
//输出：10
//解释：5 和 2 的最小公倍数是 10 。
// 
//
// 示例 2： 
//
// 输入：n = 6
//输出：6
//解释：6 和 2 的最小公倍数是 6 。注意数字会是它自身的倍数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 150 
// 
//
// Related Topics 数学 数论 👍 54 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-04-21 19:21:15
 */
public class SmallestEvenMultiple{
    public static void main(String[] args) {
        Solution solution = new SmallestEvenMultiple().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestEvenMultiple(int n) {
        return 2 * n / gcd(2, n);
    }
    public int gcd(int a, int b) {
        return b % a == 0 ? a : gcd(b % a, a);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}