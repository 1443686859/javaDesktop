//求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。 
//
// 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。 
//
// 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。 
//
// 
//
// 示例 1： 
//
// 
//输入: equation = "x+5-3+x=6+x-2"
//输出: "x=2"
// 
//
// 示例 2: 
//
// 
//输入: equation = "x=x"
//输出: "Infinite solutions"
// 
//
// 示例 3: 
//
// 
//输入: equation = "2x=x"
//输出: "x=0"
// 
//
// 
//
// 提示: 
//
// 
// 3 <= equation.length <= 1000 
// equation 只有一个 '='. 
// equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。 
// 
//
// Related Topics 数学 字符串 模拟 👍 161 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-08-10 20:25:16
 */
public class SolveTheEquation{
    public static void main(String[] args) {
        Solution solution = new SolveTheEquation().new Solution();
        System.out.println(solution.solveEquation("2x=x"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String solveEquation(String equation) {
        String[] equations = equation.split("=");
        int[] pre = calculate(equations[0]);
        int[] after = calculate(equations[1]);
        int xCount = pre[0] - after[0];
        if (xCount == 0 && after[1] == pre[1]) {
            return  "Infinite solutions";
        }
        int numCount = after[1] - pre[1];
        if (xCount == 0 && numCount != 0 || numCount % xCount != 0) {
            return "No solution";
        }
        return "x=" + numCount / xCount;
    }
    public int[] calculate(String expression) {
        int[] result = new int[2];
        int index = 0;
        while (index < expression.length()) {
            boolean positive = true;
            if (expression.charAt(index) == '-') {
                positive = false;
                index++;
            } else if (expression.charAt(index) == '+') {
                index++;
            }
            int temp = 0;
            boolean isNum = false;
            while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
                temp = temp * 10 + (expression.charAt(index) - '0');
                isNum = true;
                index++;
            }
            if (index < expression.length() && expression.charAt(index) == 'x') {
                if (temp == 0 && !isNum) {
                    temp = 1;
                }
                result[0] += positive ? temp : - temp;
                index++;
            } else {
                result[1] += positive ? temp : - temp;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}