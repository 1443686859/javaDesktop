//给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。 
//
// 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。 
//
// 
// 例如， “ace” 是 “abcde” 的子序列。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", words = ["a","bb","acd","ace"]
//输出: 3
//解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
// 
//
// Example 2: 
//
// 
//输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// words[i]和 s 都只由小写字母组成。 
// 
//
//
// Related Topics 字典树 哈希表 字符串 排序 👍 323 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2022-11-17 20:01:27
 */
public class NumberOfMatchingSubsequences{
    public static void main(String[] args) {
        Solution solution = new NumberOfMatchingSubsequences().new Solution();
        System.out.println(solution.numMatchingSubseq("abcde",
                new String[]{"a","bb","acd","ace"}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Deque<int[]>[] string = new Deque[26];
        for (int i = 0; i < string.length; i++) {
            string[i] = new ArrayDeque();
        }
        for (int i = 0; i < words.length; i++) {
            char c = words[i].charAt(0);
            string[c - 'a'].push(new int[]{i, 0});
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int length = string[c - 'a'].size();
            while (length > 0) {
                // 使用队列， 不应该用栈, 用另外一个方向出
                int[] current = string[c - 'a'].poll();
                if (current[1] == words[current[0]].length() - 1) {
                    ans++;
                } else {
                    current[1]++;
                    string[words[current[0]].charAt(current[1]) - 'a'].offer(current);
                }
                length--;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}