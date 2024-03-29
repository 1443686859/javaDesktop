//我们构建了一个包含 n 行( 索引从 1 开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。 
//
// 
// 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。 
// 
//
// 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始） 
//
// 示例 1: 
//
// 
//输入: n = 1, k = 1
//输出: 0
//解释: 第一行：0
// 
//
// 示例 2: 
//
// 
//输入: n = 2, k = 1
//输出: 0
//解释: 
//第一行: 0 
//第二行: 01
// 
//
// 示例 3: 
//
// 
//输入: n = 2, k = 2
//输出: 1
//解释:
//第一行: 0
//第二行: 01
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 30 
// 1 <= k <= 2n - 1 
// 
//
// Related Topics 位运算 递归 数学 👍 262 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-10-20 22:55:00
 */
public class KThSymbolInGrammar{
    public static void main(String[] args) {
        Solution solution = new KThSymbolInGrammar().new Solution();
        System.out.println(solution.kthGrammar(30,434991989));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthGrammar(int n, int k) {
        String a = "0";
        String b = "01";
        if (n == 1 && k == 1) {
            return Integer.parseInt(a);
        }
        if (n == 2) {
            return b.charAt(k - 1) - '0';
        }
        int index = 2;
        String c = b;
        while (index <= n) {
            String temp = c;
            c = b + b.substring(b.length() / 2) + a;
            a = b;
            b = temp;
            index++;
        }
        return c.charAt(k - 1) - '0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}