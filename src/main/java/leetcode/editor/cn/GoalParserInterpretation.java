//请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解
//析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字
//符串。 
//
// 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。 
//
// 
//
// 示例 1： 
//
// 输入：command = "G()(al)"
//输出："Goal"
//解释：Goal 解析器解释命令的步骤如下所示：
//G -> G
//() -> o
//(al) -> al
//最后连接得到的结果是 "Goal"
// 
//
// 示例 2： 
//
// 输入：command = "G()()()()(al)"
//输出："Gooooal"
// 
//
// 示例 3： 
//
// 输入：command = "(al)G(al)()()G"
//输出："alGalooG"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= command.length <= 100 
// command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成 
// 
//
// Related Topics 字符串 👍 68 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-11-06 20:06:17
 */
public class GoalParserInterpretation{
    public static void main(String[] args) {
        Solution solution = new GoalParserInterpretation().new Solution();
        System.out.println(solution.interpret("G()(al)"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String interpret(String command) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    result.append('o');
                    i++;
                } else {
                    result.append("al");
                    i += 3;
                }
            } else {
                result.append(command.charAt(i));
            }
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}