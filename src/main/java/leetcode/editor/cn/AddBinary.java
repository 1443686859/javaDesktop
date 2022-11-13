//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 位运算 数学 字符串 模拟 👍 788 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-04-03 22:42:10
 */
public class AddBinary{
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int inc = 0;
        int aStart = 1;
        int bStart = 1;
        while (aStart <= a.length() && bStart <= b.length()) {
            int currentA = a.charAt(a.length() - aStart) - '0';
            int currentB = b.charAt(b.length() - bStart) - '0';
            inc = currentA + currentB + inc;
            result.insert(0, inc % 2);
            inc = inc / 2;
            aStart++;
            bStart++;
        }
        String current = "";
        int currentStart = 0;
        if (aStart <= a.length()) {
            current = a;
            currentStart = aStart;
        } else {
            current = b;
            currentStart = bStart;
        }
        while (currentStart <= current.length()) {
            int currentChar = current.charAt(current.length() - currentStart) - '0';
            inc = inc + currentChar;
            result.insert(0, inc % 2);
            inc = inc / 2;
            currentStart++;
        }
        if (inc == 1) {
            result.insert(0, 1);
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}