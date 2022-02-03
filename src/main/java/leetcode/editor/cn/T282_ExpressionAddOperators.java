//给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回所
//有能够得到目标值的表达式。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = "123", target = 6
//输出: ["1+2+3", "1*2*3"] 
// 
//
// 示例 2: 
//
// 
//输入: num = "232", target = 8
//输出: ["2*3+2", "2+3*2"] 
//
// 示例 3: 
//
// 
//输入: num = "105", target = 5
//输出: ["1*0+5","10-5"] 
//
// 示例 4: 
//
// 
//输入: num = "00", target = 0
//输出: ["0+0", "0-0", "0*0"]
// 
//
// 示例 5: 
//
// 
//输入: num = "3456237490", target = 9191
//输出: [] 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 10 
// num 仅含数字 
// -2³¹ <= target <= 2³¹ - 1 
// 
// Related Topics 数学 字符串 回溯 👍 293 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：给表达式添加运算符
public class T282_ExpressionAddOperators{
    public static void main(String[] args) {
        Solution solution = new T282_ExpressionAddOperators().new Solution();
        // TO TEST
        System.out.println(solution.addOperators("123", 6));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int length;
        int target;
        List<String> result;
        String num;
    public List<String> addOperators(String num, int target) {
        this.length = num.length();
        this.target = target;
        result = new ArrayList<>();
        this.num = num;
        StringBuilder expr = new StringBuilder();
        backtrack(expr, 0, 0 , 0);
        return result;
    }
    public void backtrack(StringBuilder expr, int index, long currentValue, long lastValue) {
        if (index == length) {
            if (currentValue == target) {
                result.add(expr.toString());
            }
            return;
        }
        int signIndex = expr.length();
        if (index > 0) {
            // 占位符，表示最后的操作，方便赋值
            expr.append("0");
        }
        // 计算当前的数字
        long val = 0;
        // 当前数字不能为零
        for (int j = index; j < length && (j == index || num.charAt(index) != '0'); j++) {
            // 处理大于操作数。同时处理零
            val = val * 10 + num.charAt(j) - '0';
            expr.append(num.charAt(j));
            if (index == 0) {
                // 表达式不能以运算符开头
                backtrack(expr, j + 1, val, val);
            } else {
                expr.setCharAt(signIndex, '+');
                backtrack(expr, j + 1, currentValue + val, val);
                expr.setCharAt(signIndex, '-');
                backtrack(expr, j + 1, currentValue - val, -val);
                expr.setCharAt(signIndex, '*');
                backtrack(expr, j + 1, currentValue - lastValue + lastValue * val, lastValue * val);
            }
        }
        expr.setLength(signIndex);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}