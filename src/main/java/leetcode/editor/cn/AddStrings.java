//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics 数学 字符串 模拟 👍 758 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-07-17 20:12:28
 */
public class AddStrings{
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        int inc = 0;
        StringBuilder result = new StringBuilder();
        int length1 = num1.length();
        int length2 = num2.length();
        while (length2 >= 1 && length1 >= 1) {
            int current = num1.charAt(length1 - 1) - '0' + (num2.charAt(length2 - 1) - '0') + inc;
            inc = current / 10;
            current = current % 10;
            result.append(  current);
            length2 --;
            length1--;
        }
        while (length2 >= 1) {
            int current = inc + (num2.charAt(length2 - 1) - '0');
            inc = current / 10;
            current =current % 10;
            result.append(  current);
            length2--;
        }
        while (length1 >= 1) {
            int current = inc + (num1.charAt(length1 - 1) - '0');
            inc = current / 10;
            current =current % 10;
            result.append( current);
            length1--;
        }
        if (inc != 0) {
            result.append(inc);
        }
        return result.reverse().toString();
    }
}

//runtime:3 ms
//memory:42.4 MB

//leetcode submit region end(Prohibit modification and deletion)

}