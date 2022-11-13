//给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。 
//
// 
//
// 示例 1: 
//
// 
//输入：n = 2
//输出：987
//解释：99 x 91 = 9009, 9009 % 1337 = 987
// 
//
// 示例 2: 
//
// 
//输入： n = 1
//输出： 9
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 数学 👍 94 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-04-16 18:35:37
 */
public class LargestPalindromeProduct{
    public static void main(String[] args) {
        Solution solution = new LargestPalindromeProduct().new Solution();
        System.out.println(solution.largestPalindrome(1));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int start = (int)Math.pow(10, n) - 1;
        int end = (int)Math.pow(10, n - 1);
        for (int i = start; i >= end; i--) {
           long p = i;
           for (int x = i; x > 0; x /= 10) {
               p = p * 10 + x % 10;
           }
           for (long x = start; x * x >= p; --x) {
               if (p % x == 0) {
                   return (int)(p % 1337);
               }
           }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}