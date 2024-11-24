//给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 10⁹ + 7 取余 后的结果。 
//
// 同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。 
//
// 子字符串 是字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abbcccaa"
//输出：13
//解释：同构子字符串如下所列：
//"a"   出现 3 次。
//"aa"  出现 1 次。
//"b"   出现 2 次。
//"bb"  出现 1 次。
//"c"   出现 3 次。
//"cc"  出现 2 次。
//"ccc" 出现 1 次。
//3 + 1 + 2 + 1 + 3 + 2 + 1 = 13 
//
// 示例 2： 
//
// 输入：s = "xy"
//输出：2
//解释：同构子字符串是 "x" 和 "y" 。 
//
// 示例 3： 
//
// 输入：s = "zzzzz"
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写字符串组成 
// 
//
// Related Topics 数学 字符串 👍 64 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-12-27 18:06:28
 */
public class CountNumberOfHomogenousSubstrings{
    public static void main(String[] args) {
        Solution solution = new CountNumberOfHomogenousSubstrings().new Solution();
        System.out.println(solution.countHomogenous("abbcccaa"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countHomogenous(String s) {
        int mod = (int)1e9 + 7;
        int count = 1;
        int result = 0;
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (pre == s.charAt(i)) {
                count++;
            } else {
                result = (result % mod + (int)(1l * (count + 1) * count % mod) / 2) % mod;
                count = 1;
            }
            pre = s.charAt(i);
        }
        if (count != 0) {
            result = (result % mod + (int)(1l * (count + 1) * count % mod) / 2) % mod;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}