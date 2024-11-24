//如果一个密码满足以下所有条件，我们称它是一个 强 密码： 
//
// 
// 它有至少 8 个字符。 
// 至少包含 一个小写英文 字母。 
// 至少包含 一个大写英文 字母。 
// 至少包含 一个数字 。 
// 至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。 
// 它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。 
// 
//
// 给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：password = "IloveLe3tcode!"
//输出：true
//解释：密码满足所有的要求，所以我们返回 true 。
// 
//
// 示例 2： 
//
// 输入：password = "Me+You--IsMyDream"
//输出：false
//解释：密码不包含数字，且包含 2 个连续相同的字符。所以我们返回 false 。
// 
//
// 示例 3： 
//
// 输入：password = "1aB!"
//输出：false
//解释：密码不符合长度要求。所以我们返回 false 。 
//
// 
//
// 提示： 
//
// 
// 1 <= password.length <= 100 
// password 包含字母，数字和 "!@#$%^&*()-+" 这些特殊字符。 
// 
//
// Related Topics 字符串 👍 39 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-01-19 22:04:13
 */
public class StrongPasswordCheckerIi{
    public static void main(String[] args) {
        Solution solution = new StrongPasswordCheckerIi().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean strongPasswordCheckerII(String password) {
        String targetString = "!@#$%^&*()-+";
        boolean containSmall = false;
        boolean containBig = false;
        boolean containNumber = false;
        boolean containTwo = false;
        boolean containSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            if (i >= 1 && password.charAt(i - 1) == password.charAt(i)) {
                containTwo = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                containSmall = true;
            }
            if (Character.isUpperCase(password.charAt(i))) {
                containBig = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                containNumber = true;
            }
            if (targetString.indexOf(password.charAt(i)) != -1) {
                containSpecial = true;
            }
        }
        return password.length() >= 8 && containSmall && containSpecial && containBig && !containTwo && containNumber;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}