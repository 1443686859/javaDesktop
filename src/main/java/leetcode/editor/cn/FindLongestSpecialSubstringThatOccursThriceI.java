/**
给你一个仅由小写英文字母组成的字符串 s 。 

 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串
。 

 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。 

 子字符串 是字符串中的一个连续 非空 字符序列。 

 

 示例 1： 

 
输入：s = "aaaa"
输出：2
解释：出现三次的最长特殊子字符串是 "aa" ：子字符串 "aaaa"、"aaaa" 和 "aaaa"。
可以证明最大长度是 2 。
 

 示例 2： 

 
输入：s = "abcdef"
输出：-1
解释：不存在出现至少三次的特殊子字符串。因此返回 -1 。
 

 示例 3： 

 
输入：s = "abcaba"
输出：1
解释：出现三次的最长特殊子字符串是 "a" ：子字符串 "abcaba"、"abcaba" 和 "abcaba"。
可以证明最大长度是 1 。
 

 

 提示： 

 
 3 <= s.length <= 50 
 s 仅由小写英文字母组成。 
 

 👍 37 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-05-29 19:37:51
 */
public class FindLongestSpecialSubstringThatOccursThriceI{
    public static void main(String[] args) {
        Solution solution = new FindLongestSpecialSubstringThatOccursThriceI().new Solution();
        System.out.println(solution.maximumLength("abcdef"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution { 
    public int maximumLength(String s) {
        int right = s.length();
        int left = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(s, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1 <= 0 ? -1 : (left - 1);
    }
    public boolean check(String s, int target) {
        int left = 0;
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            while (s.charAt(left) != s.charAt(i)) {
                left++;
            }
            int length = i - left + 1;
            if (length >= target) {
                int index = s.charAt(i) - 'a';
                count[index]++;
                if (count[index] >= 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}