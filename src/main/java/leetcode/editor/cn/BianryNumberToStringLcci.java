//二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印
//“ERROR”。 
//
// 示例1: 
//
// 
// 输入：0.625
// 输出："0.101"
// 
//
// 示例2: 
//
// 
// 输入：0.1
// 输出："ERROR"
// 提示：0.1无法被二进制准确表示
// 
//
// 
//
// 提示： 
//
// 
// 32位包括输出中的 "0." 这两位。 
// 题目保证输入用例的小数位数最多只有 6 位 
// 
//
// Related Topics 位运算 数学 字符串 👍 123 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-03-02 21:35:35
 */
public class BianryNumberToStringLcci{
    public static void main(String[] args) {
        Solution solution = new BianryNumberToStringLcci().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String printBin(double num) {
        StringBuilder result = new StringBuilder("0.");
        int i = 0;
        while (i <= 30) {
            if (num == 0) {
                break;
            }
            num *= 2;
            if (num > 1) {
                result.append("1");
                num -= 1;
            } else {
                result.append("0");
            }
            i++;
        }
        if (num != 0) {
            return "ERROR";
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}