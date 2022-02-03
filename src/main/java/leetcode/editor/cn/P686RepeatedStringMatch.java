package leetcode.editor.cn;
//给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。 
//
// 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。 
//
// 
//
// 示例 1： 
//
// 输入：a = "abcd", b = "cdabcdab"
//输出：3
//解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
// 
//
// 示例 2： 
//
// 输入：a = "a", b = "aa"
//输出：2
// 
//
// 示例 3： 
//
// 输入：a = "a", b = "a"
//输出：1
// 
//
// 示例 4： 
//
// 输入：a = "abc", b = "wxyz"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length <= 10⁴ 
// 1 <= b.length <= 10⁴ 
// a 和 b 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 👍 216 👎 0

import javax.tools.Diagnostic;
import java.util.Random;

public class P686RepeatedStringMatch{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static final int kMod1 = 1000000007;
    static final int kMod2 = 1337;
    public int repeatedStringMatch(String a, String b) {
        int an = a.length();
        int bn = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return  -1;
        }
        if (an - index >= bn) {
            return 1;
        }
        return (bn + index - an - 1) / an + 2;
    }
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) {
            return 0;
        }
        int k1 = 1000000009;
        int k2 = 1337;
        Random random = new Random();
        int kMod1 = random.nextInt(k1) + k1;
        int kMod2 = random.nextInt(k2) + k2;
        long hashNeedle = 0;
        for (int i = 0; i < m; i++) {
            hashNeedle = (hashNeedle * kMod2 + needle.charAt(i)) % kMod1;
        }
        long hashHayStack = 0;
        long extra = 1;
        for (int i = 0; i < m - 1; i++) {
            hashHayStack = (hashHayStack * kMod2 + haystack.charAt(i % n)) % kMod1;
            extra = (extra * kMod2) % kMod1;
        }
        for (int i = m - 1; (i - m + 1) < n; i++) {
            hashHayStack = (hashHayStack * kMod2 + haystack.charAt(i % n)) % kMod1;
            if (hashHayStack == hashNeedle) {
                return i - m + 1;
            }
            hashHayStack = (hashHayStack - extra * haystack.charAt((i - m + 1) % n)) % kMod1;
            hashHayStack = (hashHayStack + kMod1) % kMod1;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}