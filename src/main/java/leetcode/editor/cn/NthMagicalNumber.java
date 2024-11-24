//一个正整数如果能被 a 或 b 整除，那么它是神奇的。 
//
// 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 10⁹ + 7 取模 后的值。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 1, a = 2, b = 3
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：n = 4, a = 2, b = 3
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 2 <= a, b <= 4 * 10⁴ 
// 
//
// 
//
// Related Topics 数学 二分查找 👍 190 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-11-22 22:29:09
 */
public class NthMagicalNumber{
    public static void main(String[] args) {
        Solution solution = new NthMagicalNumber().new Solution();
        System.out.println(solution.nthMagicalNumber(
                206117388,
                938,
                24479));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long left = Math.min(a, b);
        int mod = (int)1e9 + 7;
        long right = 1l * n * Math.max(a,b);
        int lcm = lcm(a, b);
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid, a, b, lcm ,n)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int)((right + 1) % mod);
    }
    public boolean check(long n, int a, int b, int lcm, long target) {
        long currentA = n / a;
        long currentB = n / b;
        long currentL = n / lcm;
        long currentResult = (long)(currentA + currentB - currentL);
        return currentResult >= target;
    }
    public int gcd(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if (max % min == 0) {
            return min;
        }
        return gcd(max % min, min);
    }
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}