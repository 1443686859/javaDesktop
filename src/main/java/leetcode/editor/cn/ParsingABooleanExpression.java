//给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。 
//
// 有效的表达式需遵循以下约定： 
//
// 
// "t"，运算结果为 True 
// "f"，运算结果为 False 
// "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT） 
// "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND） 
// "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR） 
// 
//
// 
//
// 示例 1： 
//
// 输入：expression = "!(f)"
//输出：true
// 
//
// 示例 2： 
//
// 输入：expression = "|(f,t)"
//输出：true
// 
//
// 示例 3： 
//
// 输入：expression = "&(t,f)"
//输出：false
// 
//
// 示例 4： 
//
// 输入：expression = "|(&(t,f,t),!(t))"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20000 
// expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。 
// expression 是以上述形式给出的有效表达式，表示一个布尔值。 
// 
//
// Related Topics 栈 递归 字符串 👍 127 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2022-11-05 14:49:50
 */
public class ParsingABooleanExpression{
    public static void main(String[] args) {
        Solution solution = new ParsingABooleanExpression().new Solution();
        System.out.println(solution.parseBoolExpr1("&(|(f))"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean parseBoolExpr(String expression) {
        if (expression.length() == 1) {
            return expression.equals("t") ? true : false;
        }
        if (expression.startsWith("!")) {
            return !parseBoolExpr(expression.substring(2, expression.length() - 1));
        }
        int cnt = 0;
        boolean result = expression.startsWith("|") ? false : true;
        int start = 2;
        for (int i = start; i < expression.length() - 1; i++) {
            if (expression.charAt(i) == '(') {
                cnt++;
            }
            if (expression.charAt(i) == ')') {
                cnt --;
            }
            if (cnt == 0 && expression.charAt(i) == ',' || i == expression.length() - 2) {
                if (expression.startsWith("|")) {
                    result |= parseBoolExpr(expression.substring(start, i == expression.length() - 2 ? i + 1 : i));
                } else {
                    result &= parseBoolExpr(expression.substring(start, i == expression.length() - 2 ? i + 1 : i));
                }
                start = i + 1;
            }

        }
        return result;
    }
    public boolean parseBoolExpr1(String expression) {
        Deque<Character> deque = new ArrayDeque<>();
        if (expression.length() == 1) {
            return expression.equals("t") ? true : false;
        }
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ')') {
                int t = 0;
                int f = 0;
                while (deque.peek() != '(') {
                    char c = deque.pop();
                    if (c == 'f') {
                        f++;
                    } else {
                        t++;
                    }
                }
                deque.pop();
                char operation = deque.pop();
                if (operation == '|') {
                    deque.push(t > 0 ? 't' : 'f');
                } else if (operation == '&') {
                    deque.push(f > 0 ? 'f' : 't');
                } else {
                    deque.push(t > 0 ? 'f' : 't');
                }
            }
            if (expression.charAt(i) != ',' && expression.charAt(i) != ')') {
                deque.push(expression.charAt(i));
            }
        }
        return deque.peek() == 'f' ? false : true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}