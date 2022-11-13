//给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 5
//输出: 2
//解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。 
//
// 示例 2: 
//
// 
//输入: n = 9
//输出: 3
//解释: 9 = 4 + 5 = 2 + 3 + 4 
//
// 示例 3: 
//
// 
//输入: n = 15
//输出: 4
//解释: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 10⁹ 
// 
// Related Topics 数学 枚举 👍 158 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-06-03 08:16:23
 */
public class ConsecutiveNumbersSum{
    public static void main(String[] args) {
        Solution solution = new ConsecutiveNumbersSum().new Solution();
        System.out.println(solution.consecutiveNumbersSum(9));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int consecutiveNumbersSum(int n) {
        int result = 0;
        int sum = 0;
        for (int i = 1; i * i < 2 * n; i++) {
           if ((n - sum) % i == 0) {
               result++;
           }
           sum += i;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}