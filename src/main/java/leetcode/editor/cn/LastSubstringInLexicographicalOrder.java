//给你一个字符串 s ，找出它的所有子串并按字典序排列，返回排在最后的那个子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abab"
//输出："bab"
//解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 
//"bab"。
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："tcode"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 4 * 10⁵ 
// s 仅含有小写英文字符。 
// 
//
// Related Topics 双指针 字符串 👍 161 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-04-24 22:50:31
 */
public class LastSubstringInLexicographicalOrder{
    public static void main(String[] args) {
        Solution solution = new LastSubstringInLexicographicalOrder().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0;
        for (int j = 1, k = 0; j + k < n; ) {
            int d = s.charAt(i + k) - s.charAt(j + k);
            if (d == 0) {
                k ++;
            } else if (d < 0) {
                i += k + 1;
                k = 0;
                if (i >= j) {
                    j = i + 1;
                }
            } else {
                j += k + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}