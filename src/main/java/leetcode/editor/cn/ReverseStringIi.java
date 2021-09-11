package leetcode.editor.cn;

//给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文组成 
// 1 <= k <= 104 
// 
// Related Topics 双指针 字符串 
// 👍 176 👎 0

public class ReverseStringIi{
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        System.out.println(solution.reverseStr("abcdefg", 8));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        int n = array.length;
        int start = 0;
        int end = (k << 1) - 1;
        while (start < end && end < n) {
            int last = end - k;
            while (start < last) {
                char temp = array[start];
                array[start] = array[last];
                array[last] = temp;
                start++;
                last--;
            }
            start = end + 1;
            end += (k << 1);
        }
        int length = (end - k) >= n ? start + k > n -1  ? n - 1 : start + k : end - k;
        while (start < length && length < n) {
            char temp = array[start];
            array[start] = array[length];
            array[length] = temp;
            start++;
            length--;
        }
        return new String(array);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}