//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。 
//
// 示例1: 
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
// 
//
// 示例2: 
//
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
// 
//
// 
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 100000]范围内。 
// 
//
// 说明: 
//
// 
// 你能只调用一次检查子串的方法吗？ 
// 
//
// Related Topics 字符串 字符串匹配 👍 200 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-09-29 20:01:40
 */
public class StringRotationLcci{
    public static void main(String[] args) {
        Solution solution = new StringRotationLcci().new Solution();
        System.out.println(solution.isFlipedString(
                "waterbottle",
                "erbottlewat"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() == s2.length() && s1.length() == 0) {
            return true;
        }
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < s1.length()) {
            while (i < s1.length() && s1.charAt(i) != s2.charAt(j)) {
                i ++;
            }
            int length = i;
            if (s1.substring(0, i).equals(s2.substring(s2.length() - length)) && s1.substring(i).equals(s2.substring(0, s2.length() - length))) {
                return true;
            }
            i++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}