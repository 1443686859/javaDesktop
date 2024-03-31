//给出一个单词数组 words ，其中每个单词都由小写英文字母组成。 
//
// 如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 
//前身 。 
//
// 
// 例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身 
// 
//
// 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是
// word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。 
//
// 从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。 
//
// 示例 1： 
//
// 
//输入：words = ["a","b","ba","bca","bda","bdca"]
//输出：4
//解释：最长单词链之一为 ["a","ba","bda","bdca"]
// 
//
// 示例 2: 
//
// 
//输入：words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
//输出：5
//解释：所有的单词都可以放入单词链 ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
// 
//
// 示例 3: 
//
// 
//输入：words = ["abcd","dbqca"]
//输出：1
//解释：字链["abcd"]是最长的字链之一。
//["abcd"，"dbqca"]不是一个有效的单词链，因为字母的顺序被改变了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 16 
// words[i] 仅由小写英文字母组成。 
// 
//
// Related Topics 数组 哈希表 双指针 字符串 动态规划 👍 269 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-04-27 18:52:18
 */
public class LongestStringChain{
    public static void main(String[] args) {
        Solution solution = new LongestStringChain().new Solution();
        System.out.println(solution.longestStrChain(new String[] {"a","aa","aab","aabb","bbaac"}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (i, j) -> i.length() - j.length());
        int max = 1;
        int n = words.length;
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int currentMax = 1;
            for (int j = i - 1; j >= 0 ; j--) {
                if (check(words[j], words[i])) {
                    currentMax = Math.max(currentMax, count[j + 1] + 1);
                    if (j == count[j + 1]) {
                        break;
                    }
                }
            }
            count[i + 1] = currentMax;
            max = Math.max(max, currentMax);
        }
        return max;
    }
    public boolean check(String pre, String after) {
        if (after.length() - pre.length() != 1) {
            return false;
        }
        for (int i = 0; i < after.length(); i++) {
            if (pre.equals(after.substring(0, i) + after.substring(i + 1, after.length()))) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}