//给你三个整数 a ，b 和 n ，请你返回 (a XOR x) * (b XOR x) 的 最大值 且 x 需要满足 0 <= x < 2ⁿ。 
//
// 由于答案可能会很大，返回它对 109 + 7 取余 后的结果。 
//
// 注意，XOR 是按位异或操作。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 12, b = 5, n = 4
//输出：98
//解释：当 x = 2 时，(a XOR x) = 14 且 (b XOR x) = 7 。所以，(a XOR x) * (b XOR x) = 98 。
//98 是所有满足 0 <= x < 2n 中 (a XOR x) * (b XOR x) 的最大值。
// 
//
// 示例 2： 
//
// 
//输入：a = 6, b = 7 , n = 5
//输出：930
//解释：当 x = 25 时，(a XOR x) = 31 且 (b XOR x) = 30 。所以，(a XOR x) * (b XOR x) = 930 
//。
//930 是所有满足 0 <= x < 2n 中 (a XOR x) * (b XOR x) 的最大值。 
//
// 示例 3： 
//
// 
//输入：a = 1, b = 6, n = 3
//输出：12
//解释： 当 x = 5 时，(a XOR x) = 4 且 (b XOR x) = 3 。所以，(a XOR x) * (b XOR x) = 12 。
//12 是所有满足 0 <= x < 2n 中 (a XOR x) * (b XOR x) 的最大值。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= a, b < 2⁵⁰ 
// 0 <= n <= 50 
// 
//
// 👍 8 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-11-20 23:29:43
 */
public class MaximumXorProduct{
    public static void main(String[] args) {
        Solution solution = new MaximumXorProduct().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        if (a < b) {
            long temp = b;
            b = a;
            a = temp;
        }
        long mask = (1L << n) - 1;
        long ax = a & ~mask;
        long bx = b & ~mask;
        a &= mask;
        b &= mask;

        long left = a ^ b;
        long one = left ^ mask;
        ax |= one;
        bx |= one;
        if (ax == bx && left > 0) {
            long highBit = 1L << (63 - Long.numberOfLeadingZeros(left));
            ax |= highBit;
            left ^= highBit;
        }
        bx |= left;
        long MOD = 1_000_000_007L;
        return (int)(ax % MOD * (bx % MOD) % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}