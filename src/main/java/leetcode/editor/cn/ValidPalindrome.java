//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 527 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-05-09 20:48:06
 */
public class ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            while (l < n && !Character.isLetter(s.charAt(l)) && !Character.isDigit(s.charAt(l))) {
                l++;
            }
            while (r >= 0 && !Character.isLetter(s.charAt(r)) && !Character.isDigit(s.charAt(r))) {
                r--;
            }
            if (r < 0 || l >= n) {
                break;
            }
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            if (Character.isDigit(cl) && Character.isDigit(cr)) {
                if (cl != cr) {
                    return false;
                }
            }
            if (Character.isLetter(cl) && Character.isLetter(cr)) {
                if (Math.abs(cl - cr) != 0 &&  Math.abs(cl - cr) != 32) {
                    return false;
                }
            }
            if (Character.isLetter(cl) && Character.isDigit(cr)) {
                return false;
            }
            if (Character.isDigit(cl) && Character.isLetter(cr)) {
                return false;
            }
            l++;
            r--;

        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}