//给你一个字符串 word 和一个字符串数组 forbidden 。 
//
// 如果一个字符串不包含 forbidden 中的任何字符串，我们称这个字符串是 合法 的。 
//
// 请你返回字符串 word 的一个 最长合法子字符串 的长度。 
//
// 子字符串 指的是一个字符串中一段连续的字符，它可以为空。 
//
// 
//
// 示例 1： 
//
// 输入：word = "cbaaaabc", forbidden = ["aaa","cb"]
//输出：4
//解释：总共有 9 个合法子字符串："c" ，"b" ，"a" ，"ba" ，"aa" ，"bc" ，"baa" ，"aab" 和 "aabc" 。最长合法子
//字符串的长度为 4 。
//其他子字符串都要么包含 "aaa" ，要么包含 "cb" 。 
//
// 示例 2： 
//
// 输入：word = "leetcode", forbidden = ["de","le","e"]
//输出：4
//解释：总共有 11 个合法子字符串："l" ，"t" ，"c" ，"o" ，"d" ，"tc" ，"co" ，"od" ，"tco" ，"cod" 和 
//"tcod" 。最长合法子字符串的长度为 4 。
//所有其他子字符串都至少包含 "de" ，"le" 和 "e" 之一。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 10⁵ 
// word 只包含小写英文字母。 
// 1 <= forbidden.length <= 10⁵ 
// 1 <= forbidden[i].length <= 10 
// forbidden[i] 只包含小写英文字母。 
// 
//
// 👍 11 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-07-17 22:09:23
 */
public class LengthOfTheLongestValidSubstring{
    public static void main(String[] args) {
        Solution solution = new LengthOfTheLongestValidSubstring().new Solution();
        System.out.println(solution.longestValidSubstring("bbccc", Arrays.asList("ccc","bcba","bcc","bcc")));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int result = 0;
        TreeC root = new TreeC();
        for (String f : forbidden) {
            add(root, new StringBuilder(f).reverse().toString());
        }
        int index = -1;
        int pre = 0;
        while (index < word.length()) {
            int current = search(root, word, index, pre);
            if (current != 0) {
                pre = index - current + 2;
            }
            result = Math.max(result, index - pre + 1);
            index ++;
        }
        return Math.max(result, index - pre);
    }
    class TreeC {
        boolean isEnd;
        TreeC[] next;

        public TreeC() {
            isEnd = false;
            next = new TreeC[26];
        }
    }
    void add(TreeC root, String current) {
        TreeC temp = root;
        for (Character c : current.toCharArray()) {
            int index = c - 'a';
            if (temp.next[index] == null) {
                temp.next[index] = new TreeC();
            }
            temp = temp.next[index];
        }
        temp.isEnd = true;
    }

    int search(TreeC root, String target, int end, int start) {
        TreeC temp = root;
        int index = end;
        int result = 0;
        while (temp != null && index >= start && !temp.isEnd) {
            int currentIndex= target.charAt(index) - 'a';
            temp = temp.next[currentIndex];
            if (temp != null && temp.isEnd) {
                result = end - index + 1;
                break;
            }
            index--;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}