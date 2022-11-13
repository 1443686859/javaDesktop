//给你一个由小写字母组成的字符串 s ，和一个整数 k 。如果满足下述条件，则可以将字符串 t 视作是 理想字符串 ： 
//
// 
// t 是字符串 s 的一个子序列。 
// t 中每两个 相邻 字母在字母表中位次的绝对差值小于或等于 k 。 
// 
//
// 返回 最长 理想字符串的长度。 
//
// 字符串的子序列同样是一个字符串，并且子序列还满足：可以经由其他字符串删除某些字符（也可以不删除）但不改变剩余字符的顺序得到。 
//
// 注意：字母表顺序不会循环。例如，'a' 和 'z' 在字母表中位次的绝对差值是 25 ，而不是 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "acfgbd", k = 2
//输出：4
//解释：最长理想字符串是 "acbd" 。该字符串长度为 4 ，所以返回 4 。
//注意 "acfgbd" 不是理想字符串，因为 'c' 和 'f' 的字母表位次差值为 3 。 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 3
//输出：4
//解释：最长理想字符串是 "abcd" ，该字符串长度为 4 ，所以返回 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// 0 <= k <= 25 
// s 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 动态规划 👍 19 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-08-12 22:34:13
 */
public class LongestIdealSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestIdealSubsequence().new Solution();
        System.out.println(solution.longestIdealString(
                "acfgbd", 2));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] result = new int[n];
        result[0] = 1;
        int max = 0;
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            int currentResult = 1;
            int currentIndex = s.charAt(i) - 'a';
            int startIndex = Math.max(currentIndex - k, 0);
            int endIndex = Math.min(25, currentIndex + k);
            for (int j = startIndex; j <= endIndex; j++) {
                currentResult = Math.max(currentResult, count[j] + 1);
            }
            count[currentIndex] = currentResult;
            result[i] = currentResult;
            max = Math.max(max, currentResult);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}