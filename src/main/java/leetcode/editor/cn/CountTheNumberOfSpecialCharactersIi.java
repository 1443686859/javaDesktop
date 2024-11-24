//给你一个字符串 word。如果 word 中同时出现某个字母 c 的小写形式和大写形式，并且 每个 小写形式的 c 都出现在第一个大写形式的 c 之前，则称
//字母 c 是一个 特殊字母 。 
//
// 返回 word 中 特殊字母 的数量。 
//
// 
//
// 示例 1: 
//
// 
// 输入：word = "aaAbcBC" 
// 
//
// 输出：3 
//
// 解释： 
//
// 特殊字母是 'a'、'b' 和 'c'。 
//
// 示例 2: 
//
// 
// 输入：word = "abc" 
// 
//
// 输出：0 
//
// 解释： 
//
// word 中不存在特殊字母。 
//
// 示例 3: 
//
// 
// 输入：word = "AbBCab" 
// 
//
// 输出：0 
//
// 解释： 
//
// word 中不存在特殊字母。 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 2 * 10⁵ 
// word 仅由小写和大写英文字母组成。 
// 
//
// 👍 5 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-04-23 01:34:31
 */
public class CountTheNumberOfSpecialCharactersIi{
    public static void main(String[] args) {
        Solution solution = new CountTheNumberOfSpecialCharactersIi().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfSpecialChars(String word) {
        int[] maxIndex = new int[26];
        int[] minIndex = new int[26];
        Arrays.fill(maxIndex, -1);
        Arrays.fill(minIndex, Integer.MAX_VALUE);
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                minIndex[c - 'A'] = Math.min(minIndex[c-'A'], i);
            } else {
                maxIndex[c - 'a'] = Math.max(maxIndex[c - 'a'], i);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (maxIndex[i] != -1 && minIndex[i] != Integer.MAX_VALUE) {
                result += maxIndex[i] < minIndex[i] ? 1 : 0;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}