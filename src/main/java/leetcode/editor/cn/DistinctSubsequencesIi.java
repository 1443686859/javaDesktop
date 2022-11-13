//给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。 
//
// 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：7
//解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
// 
//
// 示例 2： 
//
// 
//输入：s = "aba"
//输出：6
//解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
// 
//
// 示例 3： 
//
// 
//输入：s = "aaa"
//输出：3
//解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
//
// 
//
// Related Topics 字符串 动态规划 👍 247 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-10-14 16:35:35
 */
public class DistinctSubsequencesIi{
    public static void main(String[] args) {
        Solution solution = new DistinctSubsequencesIi().new Solution();
        System.out.println(solution.distinctSubseqII("aba"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int mod = (int)(1e9 + 7);
    public int distinctSubseqII(String s) {
        int n = s.length();
        int[] dp = new int[26];
        // 以空串为开始， 新增字符串为之前的字符串末尾添加，则能获得 新的字符串数等于已有的字符串数
        // 若有重复，则必为之前的重复字符引入，则为那个重复字符的新增字符串数
        int result = 1;
        for (int i = 0; i < n; i++) {
            // 默认结果
            int currentResult = result;
            // 记录当前默认结果数，减去重复数
            result = ((result + currentResult) % mod - dp[s.charAt(i) - 'a'] % mod + mod) % mod;
            // 记录新增字符串数
            dp[s.charAt(i) - 'a'] = currentResult;
        }
        return result - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}