package leetcode.editor.cn;
//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ ）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xⁿ <= 104 
// 
// Related Topics 递归 数学 👍 855 👎 0

public class P50PowxN{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.00000d,-2147483648));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    public double myPow(double x, int n) {
        long pow = (long)n;
        if (x == 1) {
            return 1d;
        }
        if (n < 0) {
            pow = -pow;
        }
        double result = fastPow(x, pow);
        if (n < 0) {
            return 1 / result;
        }
        return result;
    }
    public double fastPow(double base, long n) {
        double result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                result *= base;
            }
            base *= base;
            n >>= 1;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}