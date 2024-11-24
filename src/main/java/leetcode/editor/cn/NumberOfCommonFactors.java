//给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。 
//
// 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。 
//
// 
//
// 示例 1： 
//
// 输入：a = 12, b = 6
//输出：4
//解释：12 和 6 的公因子是 1、2、3、6 。
// 
//
// 示例 2： 
//
// 输入：a = 25, b = 30
//输出：2
//解释：25 和 30 的公因子是 1、5 。 
//
// 
//
// 提示： 
//
// 
// 1 <= a, b <= 1000 
// 
//
// Related Topics 数学 枚举 数论 👍 36 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-04-05 15:10:50
 */
public class NumberOfCommonFactors{
    public static void main(String[] args) {
        Solution solution = new NumberOfCommonFactors().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int commonFactors(int a, int b) {
        int max = gcd(a, b);
        int result = 1;
        for (int i = 2; i <= max; i++) {
            if (a % i == 0 && b % i == 0) {
                result++;
            }
        }
        return result;
    }
    public int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}