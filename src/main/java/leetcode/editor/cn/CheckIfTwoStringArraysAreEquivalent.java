//给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。 
//
// 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
//输出：true
//解释：
//word1 表示的字符串为 "ab" + "c" -> "abc"
//word2 表示的字符串为 "a" + "bc" -> "abc"
//两个字符串相同，返回 true 
//
// 示例 2： 
//
// 
//输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 10³ 
// 1 <= word1[i].length, word2[i].length <= 10³ 
// 1 <= sum(word1[i].length), sum(word2[i].length) <= 10³ 
// word1[i] 和 word2[i] 由小写字母组成 
// 
//
// Related Topics 数组 字符串 👍 77 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-11-01 22:37:49
 */
public class CheckIfTwoStringArraysAreEquivalent{
    public static void main(String[] args) {
        Solution solution = new CheckIfTwoStringArraysAreEquivalent().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int index1 = 0;
        int index2 = 0;
        int start1 = 0;
        int start2 = 0;
        while (index1 < word1.length && index2 < word2.length) {
            if (word1[index1].charAt(start1) != word2[index2].charAt(start2)) {
                return false;
            }
            start1++;
            start2++;
            if (start1 == word1[index1].length()) {
                start1 = 0;
                index1++;
            }
            if (start2 == word2[index2].length()) {
                start2 = 0;
                index2++;
            }
        }
        if (index1 != word1.length) {
            return start1 == word1[index1].length();
        }
        if (index2 != word2.length) {
            return start2 == word2[index2].length();
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}