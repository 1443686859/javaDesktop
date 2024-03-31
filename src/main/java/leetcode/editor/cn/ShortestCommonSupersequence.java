//给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。 
//
// （如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列） 
//
// 
//
// 示例： 
//
// 输入：str1 = "abac", str2 = "cab"
//输出："cabac"
//解释：
//str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。 
//str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
//最终我们给出的答案是满足上述属性的最短字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= str1.length, str2.length <= 1000 
// str1 和 str2 都由小写英文字母组成。 
// 
//
// Related Topics 字符串 动态规划 👍 211 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-03-28 21:54:41
 */
public class ShortestCommonSupersequence{
    public static void main(String[] args) {
        Solution solution = new ShortestCommonSupersequence().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] s = str1.toCharArray();
        char[] t = str2.toCharArray();
        int[][] min = new int[s.length + 1][t.length + 1];
        for (int j = 1; j < t.length; j++) {
            min[0][j] = j;
        }
        for (int j = 1; j < s.length; j++) {
            min[j][0] = j;
        }
        for (int i = 0; i < s.length; i ++) {
            for (int j = 0; j < t.length; j++) {
                if (s[i] == t[j]) {
                    min[i + 1][j + 1] = min[i][j] + 1;
                } else {
                    min[i + 1][j + 1] = Math.min(min[i][j + 1], min[i + 1][j]) + 1;
                }
            }
        }
        int max = min[s.length][t.length];
        char[] result = new char[max];
        for (int i = s.length - 1, j = t.length - 1, index = max - 1; ;) {
            if (i < 0) {
                System.arraycopy(t, 0, result, 0, j + 1);
                break;
            }
            if (j < 0) {
                System.arraycopy(s, 0, result, 0, i + 1);
                break;
            }
            if (s[i] == t[j]) {
                result[index --] = s[i --];
                j--;
            } else if (min[i + 1][j + 1] == min[i + 1][j] + 1) {
                result[index--] = t[j --];
            } else {
                result[index--] = s[i--];
            }
        }
        return new String(result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}