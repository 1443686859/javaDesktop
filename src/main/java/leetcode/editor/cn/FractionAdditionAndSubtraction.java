//给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
//
// 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为
// 2/1。 
//
// 
//
// 示例 1: 
//
// 
//输入: expression = "-1/2+1/2"
//输出: "0/1"
// 
//
// 示例 2: 
//
// 
//输入: expression = "-1/2+1/2+1/3"
//输出: "1/3"
// 
//
// 示例 3: 
//
// 
//输入: expression = "1/3-1/2"
//输出: "-1/6"
// 
//
// 
//
// 提示: 
//
// 
// 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
// 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。 
// 输入只包含合法的最简分数，每个分数的分子与分母的范围是 [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。 
// 输入的分数个数范围是 [1,10]。 
// 最终结果的分子与分母保证是 32 位整数范围内的有效整数。 
// 
//
// Related Topics 数学 字符串 模拟 👍 109 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2022-07-27 20:47:33
 */
public class FractionAdditionAndSubtraction{
    public static void main(String[] args) {
        Solution solution = new FractionAdditionAndSubtraction().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionAddition(String expression) {
        Deque<int[]> total = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            int j = i;
            if (currentChar == '-' || currentChar == '+') {
                j = i + 1;
            }
            int[] result = new int[2];
            while (j < expression.length() && expression.charAt(j) != '/') {
                result[0] = result[0] * 10 + expression.charAt(j) - '0';
                j++;
            }
            j++;
            while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
                result[1] = result[1] * 10 + expression.charAt(j) - '0';
                j++;
            }
            if (currentChar == '-') {
                result[0] *= -1;
            }
            i = j - 1;
            total.add(result);
        }
        while (total.size() != 1) {
            int[] pre = total.poll();
            int[] after = total.poll();
            int[] result = new int[2];
            int gcd = gcd(pre[1], after[1]);
            result[1] = pre[1] * after[1] / gcd;
            result[0] = pre[0] * after[1] / gcd + after[0] * pre[1] / gcd;
            if (result[0] == 0) {
                result[1] = 1;
            }
            int resultGcd = gcd(Math.abs(result[0]), result[1]);
            result[0] /= resultGcd;
            result[1] /= resultGcd;
            total.addFirst(result);
        }
        int[] result = total.poll();
        return result[0] + "/" + result[1];
    }

    public int gcd(int x, int y) {
        int a = Math.min(x, y);
        int b = Math.max(x, y);
        if (b % a == 0) {
            return a;
        }
        int nb = b - a;
        nb = nb % a;
        return gcd(nb, a);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}