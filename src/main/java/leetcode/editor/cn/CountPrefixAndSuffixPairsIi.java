//给你一个下标从 0 开始的字符串数组 words 。 
//
// 定义一个 布尔 函数 isPrefixAndSuffix ，它接受两个字符串参数 str1 和 str2 ： 
//
// 
// 当 str1 同时是 str2 的前缀（prefix）和后缀（suffix）时，isPrefixAndSuffix(str1, str2) 返回 
//true，否则返回 false。 
// 
//
// 例如，isPrefixAndSuffix("aba", "ababa") 返回 true，因为 "aba" 既是 "ababa" 的前缀，也是 
//"ababa" 的后缀，但是 isPrefixAndSuffix("abc", "abcd") 返回 false。 
//
// 以整数形式，返回满足 i < j 且 isPrefixAndSuffix(words[i], words[j]) 为 true 的下标对 (i, j) 的
// 数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["a","aba","ababa","aa"]
//输出：4
//解释：在本示例中，计数的下标对包括：
//i = 0 且 j = 1 ，因为 isPrefixAndSuffix("a", "aba") 为 true 。
//i = 0 且 j = 2 ，因为 isPrefixAndSuffix("a", "ababa") 为 true 。
//i = 0 且 j = 3 ，因为 isPrefixAndSuffix("a", "aa") 为 true 。
//i = 1 且 j = 2 ，因为 isPrefixAndSuffix("aba", "ababa") 为 true 。
//因此，答案是 4 。 
//
// 示例 2： 
//
// 
//输入：words = ["pa","papa","ma","mama"]
//输出：2
//解释：在本示例中，计数的下标对包括：
//i = 0 且 j = 1 ，因为 isPrefixAndSuffix("pa", "papa") 为 true 。
//i = 2 且 j = 3 ，因为 isPrefixAndSuffix("ma", "mama") 为 true 。
//因此，答案是 2 。 
//
// 示例 3： 
//
// 
//输入：words = ["abab","ab"]
//输出：0
//解释：在本示例中，唯一有效的下标对是 i = 0 且 j = 1 ，但是 isPrefixAndSuffix("abab", "ab") 为 false 。
//
//因此，答案是 0 。 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10⁵ 
// 1 <= words[i].length <= 10⁵ 
// words[i] 仅由小写英文字母组成。 
// 所有 words[i] 的长度之和不超过 5 * 10⁵ 。 
// 
//
// 👍 10 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;
import java.util.Set;

/**
 * @author  YourName
 * @date 2024-02-21 23:49:00
 */
public class CountPrefixAndSuffixPairsIi{
    public static void main(String[] args) {
        Solution solution = new CountPrefixAndSuffixPairsIi().new Solution();
        System.out.println(solution.countPrefixSuffixPairs(new String[]{"bcba","c","caccb","a","caca","aaaa","cbbac","cbc","ccb","a","bbb","cb","babcc","cbb","a","abc","ba","aaab","ab","baa","cbac"}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countPrefixSuffixPairs(String[] words) {

        Map<String, Integer> count = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        long result = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (String word : words) {
            int[] next = getNext(word);
            result += get(next, count, word, set, max, min);
            count.put(word, count.getOrDefault(word, 0) + 1);
            max = Math.max(max, word.length());
            min = Math.min(min, word.length());
            set.add(word.length());
        }
        return result;
    }
    public long get(int[] next, Map<String, Integer> count, String current, Set<Integer> set, int max, int min) {
        int n = Math.min(next[next.length - 1], max);
        long result = 0;
        result += count.getOrDefault(current, 0);
        while (n >= min) {
            while (n >= min && !set.contains(n)) {
                n = next[n - 1];
            }
            if (n < min) {
                break;
            }
            result += count.getOrDefault(current.substring(0, n), 0);
            n = next[n - 1];
        }
        return result;
    }
    public int[] getNext(String word) {
        int n = word.length();
        int[] result = new int[n];
        int index = 0;
        for (int i = 1; i < n; i++) {
            while (index > 0 && word.charAt(i) != word.charAt(index)) {
                index = result[index - 1];
            }
            if (word.charAt(i) == word.charAt(index)) {
                index++;
            }
            result[i] = index;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}