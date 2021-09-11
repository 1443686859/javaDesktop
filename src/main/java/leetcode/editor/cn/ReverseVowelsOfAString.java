package leetcode.editor.cn;

//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 205 👎 0

public class ReverseVowelsOfAString{
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        System.out.println(solution.reverseVowels("he  llo"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int n = s.length() - 1;
        int i = 0;
        while (i < n) {
            if (check(array[i]) && check(array[n])) {
                char temp = array[i];
                array[i] = array[n];
                array[n] = temp;
                i++;
                n--;
            }
            while (i < s.length() && !check(array[i])) {
                i++;
            }
            while (n >= 0 && !check(array[n])) {
                n--;
            }
        }
        return new String(array);
    }
    public boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}