//求出大于或等于 N 的最小回文素数。 
//
// 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。 
//
// 例如，2，3，5，7，11 以及 13 是素数。 
//
// 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。 
//
// 例如，12321 是回文数。 
//
// 
//
// 示例 1： 
//
// 输入：6
//输出：7
// 
//
// 示例 2： 
//
// 输入：8
//输出：11
// 
//
// 示例 3： 
//
// 输入：13
//输出：101 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^8 
// 答案肯定存在，且小于 2 * 10^8。 
// 
//
// 
//
// 
//
// Related Topics 数学 👍 87 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-05-02 23:21:39
 */
public class PrimePalindrome{
    public static void main(String[] args) {
        Solution solution = new PrimePalindrome().new Solution();
        System.out.println(solution.primePalindrome(13));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int primePalindrome(int n) {
        String current = n + "";
        int index = (current.length() + 1)/ 2;
        int pre = Integer.parseInt(current.substring(0, index));
        int currentResult = change(pre);
        while (true) {
            if (currentResult >= n && check(currentResult)) {
                break;
            }
            pre++;
            currentResult = change(pre);
        }
        return currentResult;
    }
    public boolean check(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int change(int n) {
        String current = n + "";
        if ((current.length() & 1) == 0 || current.length() == 1) {
            StringBuilder result = new StringBuilder(current);
            return Integer.parseInt(result.toString() + result.reverse().toString());
        } else {
            StringBuilder result = new StringBuilder(current);
            result.deleteCharAt(result.length() - 1);
            return Integer.parseInt(current + result.reverse().toString());
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}