package leetcode.editor.cn;
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 665 👎 0

import java.util.ArrayList;
import java.util.List;

public class P438FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution current = new P438FindAllAnagramsInAString().new Solution();
        System.out.println(current.findAnagrams("abab","ab"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
     class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] current = new int[26];
        for (char ch : p.toCharArray()) {
            current[ch - 'a'] ++;
        }
        List<Integer> result = new ArrayList<>();
        int n = p.length();
        int length = 0;
        int index = 0;
        int[] temp = new int[26];
        while (length < n && index < s.length()) {
            temp[s.charAt(index) - 'a'] ++;
            length ++;
            index ++;
            if (length == n) {
                length -= 1;
                if (equals(temp, current)) {
                    result.add(index - n);
                }
                temp[s.charAt(index - n) - 'a']--;
            }
        }
        return result;
    }
    public boolean equals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}