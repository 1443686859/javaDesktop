//给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例： 
//
// 输入: "sea", "eat"
//输出: 2
//解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
// 
//
// 
//
// 提示： 
//
// 
// 给定单词的长度不超过500。 
// 给定单词中的字符只含有小写字母。 
// 
// Related Topics 字符串 动态规划 👍 257 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：两个字符串的删除操作
public class T583_DeleteOperationForTwoStrings{
    public static void main(String[] args) {
        Solution solution = new T583_DeleteOperationForTwoStrings().new Solution();
        System.out.println(solution.minDistance( "trinitrophenylmethylnitramine",
                "dinitrophenylhydrazine"));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int minDistance(String word1, String word2) {
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            result[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            result[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            char c = word1.charAt(i - 1);
            for (int j = 1; j <= word2.length(); j++) {
                char c2 = word2.charAt(j - 1);
                if (c == c2) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + 1;
                }
            }
        }
        return result[word1.length()][word2.length()];
    }*/
    public int minDistance(String word1, String word2) {
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            char c = word1.charAt(i - 1);
            for (int j = 1; j <= word2.length(); j++) {
                char c2 = word2.charAt(j - 1);
                if (c == c2) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        int maxLen = result[word1.length()][word2.length()];
        return word1.length() - maxLen + word2.length() - maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}