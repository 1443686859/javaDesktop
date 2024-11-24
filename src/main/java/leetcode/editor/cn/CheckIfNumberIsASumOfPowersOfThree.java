//给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。 
//
// 对于一个整数 y ，如果存在整数 x 满足 y == 3ˣ ，我们称这个整数 y 是三的幂。 
//
// 
//
// 示例 1： 
//
// 输入：n = 12
//输出：true
//解释：12 = 3¹ + 3²
// 
//
// 示例 2： 
//
// 输入：n = 91
//输出：true
//解释：91 = 3⁰ + 3² + 3⁴
// 
//
// 示例 3： 
//
// 输入：n = 21
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁷ 
// 
//
// Related Topics 数学 👍 98 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-12-09 22:34:25
 */
public class CheckIfNumberIsASumOfPowersOfThree{
    public static void main(String[] args) {
        Solution solution = new CheckIfNumberIsASumOfPowersOfThree().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            int current = get(n);
            if (n >= 2 * current) {
                return false;
            }
            n -= current;
        }
        return true;
    }
    public int get(int n) {
        long start = 1l;
        while (start <= n) {
            start *= 3;
        }
        return (int) (start / 3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}