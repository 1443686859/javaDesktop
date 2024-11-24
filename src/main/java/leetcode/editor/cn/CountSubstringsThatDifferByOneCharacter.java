//给你两个字符串 s 和 t ，请你找出 s 中的非空子串的数目，这些子串满足替换 一个不同字符 以后，是 t 串的子串。换言之，请你找到 s 和 t 串中 
//恰好 只有一个字符不同的子字符串对的数目。 
//
// 比方说， "computer" and "computation" 只有一个字符不同： 'e'/'a' ，所以这一对子字符串会给答案加 1 。 
//
// 请你返回满足上述条件的不同子字符串对数目。 
//
// 一个 子字符串 是一个字符串中连续的字符。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aba", t = "baba"
//输出：6
//解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//加粗部分分别表示 s 和 t 串选出来的子字符串。
// 
//
//示例 2：
//
// 
//输入：s = "ab", t = "bb"
//输出：3
//解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
//("ab", "bb")
//("ab", "bb")
//("ab", "bb")
//加粗部分分别表示 s 和 t 串选出来的子字符串。
// 
//
//示例 3：
//
// 
//输入：s = "a", t = "a"
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：s = "abe", t = "bbc"
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 100 
// s 和 t 都只包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 动态规划 👍 144 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-03-27 22:20:06
 */
public class CountSubstringsThatDifferByOneCharacter{
    public static void main(String[] args) {
        Solution solution = new CountSubstringsThatDifferByOneCharacter().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s, String t) {
        int result = 0;
        int n = s.length();
        int m = t.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int diff = 0;
                int maxK = Math.min(n - i, m - j);
                for (int k = 0; k < maxK; k ++) {
                    diff += s.charAt(i + k) == t.charAt(j + k) ? 0 : 1;
                    if (diff == 1) {
                        result ++;
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}