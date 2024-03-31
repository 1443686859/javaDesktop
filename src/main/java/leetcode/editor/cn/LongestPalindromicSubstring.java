//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 5986 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-12-21 20:33:10
 */
public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123"));
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] result = new int[n];
        Arrays.fill(result, 1);
        if (check(s, 0, n - 1)) {
            return s;
        }
        int maxIndex = 0;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            int preIndex = i - result[i - 1] - 1;
            if (preIndex >= 0 && s.charAt(preIndex) == s.charAt(i)) {
                result[i] = result[i - 1] + 2;
            } else {
                preIndex = Math.max(0, preIndex);
                boolean flag = false;
                for (int start = preIndex; start < i; start++) {
                    if (s.charAt(start) != s.charAt(i)) {
                        continue;
                    }
                    if (check(s, start + 1, i - 1)) {
                        result[i] = i - start + 1;
                        flag = true;
                    }
                    if (flag) {
                        break;
                    }
                }
            }
            if (result[i] > maxLength) {
                maxIndex = i;
                maxLength = result[i];
            }
        }
        return s.substring(maxIndex - maxLength + 1, maxIndex + 1);
    }
    public boolean check(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right --;
        }
        return true;
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}