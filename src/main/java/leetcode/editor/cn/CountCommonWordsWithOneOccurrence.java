//给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing",
//"leetcode","is"]
//输出：2
//解释：
//- "leetcode" 在两个数组中都恰好出现一次，计入答案。
//- "amazing" 在两个数组中都恰好出现一次，计入答案。
//- "is" 在两个数组中都出现过，但在 words1 中出现了 2 次，不计入答案。
//- "as" 在 words1 中出现了一次，但是在 words2 中没有出现过，不计入答案。
//所以，有 2 个字符串在两个数组中都恰好出现了一次。
// 
//
// 示例 2： 
//
// 
//输入：words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
//输出：0
//解释：没有字符串在两个数组中都恰好出现一次。
// 
//
// 示例 3： 
//
// 
//输入：words1 = ["a","ab"], words2 = ["a","a","a","ab"]
//输出：1
//解释：唯一在两个数组中都出现一次的字符串是 "ab" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words1.length, words2.length <= 1000 
// 1 <= words1[i].length, words2[j].length <= 30 
// words1[i] 和 words2[j] 都只包含小写英文字母。 
// 
//
// Related Topics 数组 哈希表 字符串 计数 👍 29 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2024-01-12 22:01:44
 */
public class CountCommonWordsWithOneOccurrence{
    public static void main(String[] args) {
        Solution solution = new CountCommonWordsWithOneOccurrence().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Integer> count1Map = new HashMap<>();
        for (String word : words1) {
            countMap.merge(word, 1, Integer::sum);
        }
        for (String word : words2) {
            count1Map.merge(word, 1, Integer::sum);
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : count1Map.entrySet()) {
            if (entry.getValue() == 1 && countMap.getOrDefault(entry.getKey(), 0) == 1) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}