//给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。 
//
// 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 
//也应该出现在 y 之前。 
//
// 返回 满足这个性质的 s 的任意排列 。 
//
// 
//
// 示例 1: 
//
// 
//输入: order = "cba", s = "abcd"
//输出: "cbad"
//解释: 
//“a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
//因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。 
//
// 示例 2: 
//
// 
//输入: order = "cbafg", s = "abcd"
//输出: "cbad"
// 
//
// 
//
// 提示: 
//
// 
// 1 <= order.length <= 26 
// 1 <= s.length <= 200 
// order 和 s 由小写英文字母组成 
// order 中的所有字符都 不同 
// 
//
// Related Topics 哈希表 字符串 排序 👍 160 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-11-13 19:49:15
 */
public class CustomSortString{
    public static void main(String[] args) {
        Solution solution = new CustomSortString().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String customSortString(String order, String s) {
        int defaultIndex = order.length();
        int[][] orderArray = new int[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            orderArray[i][0] = s.charAt(i);
            int index = order.indexOf(s.charAt(i));
            if (index != -1) {
                orderArray[i][1] = index;
            } else {
                orderArray[i][1] = defaultIndex++;
            }
        }
        Arrays.sort(orderArray, (a, b) -> a[1] - b[1]);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            result.append((char)orderArray[i][0]);
        }
        return result.toString();
    }
    public String customSortString1(String order, String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            while (count[order.charAt(i) -'a'] -- > 0) {
                result.append(order.charAt(i));
            }
        }
        for (int i = 0; i < 26; i++) {
            while (count[i] -- > 0) {
                result.append((char)('a' + i));
            }
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}