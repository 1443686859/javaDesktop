/**
如果一个字符串满足以下条件，则称其为 美丽字符串 ： 

 
 它由英语小写字母表的前 k 个字母组成。 
 它不包含任何长度为 2 或更长的回文子字符串。 
 

 给你一个长度为 n 的美丽字符串 s 和一个正整数 k 。 

 请你找出并返回一个长度为 n 的美丽字符串，该字符串还满足：在字典序大于 s 的所有美丽字符串中字典序最小。如果不存在这样的字符串，则返回一个空字符串。 

 对于长度相同的两个字符串 a 和 b ，如果字符串 a 在与字符串 b 不同的第一个位置上的字符字典序更大，则字符串 a 的字典序大于字符串 b 。 

 
 例如，"abcd" 的字典序比 "abcc" 更大，因为在不同的第一个位置（第四个字符）上 d 的字典序大于 c 。 
 

 

 示例 1： 

 
输入：s = "abcz", k = 26
输出："abda"
解释：字符串 "abda" 既是美丽字符串，又满足字典序大于 "abcz" 。
可以证明不存在字符串同时满足字典序大于 "abcz"、美丽字符串、字典序小于 "abda" 这三个条件。
 

 示例 2： 

 
输入：s = "dc", k = 4
输出：""
解释：可以证明，不存在既是美丽字符串，又字典序大于 "dc" 的字符串。 

 

 提示： 

 
 1 <= n == s.length <= 10⁵ 
 4 <= k <= 26 
 s 是一个美丽字符串 
 

 👍 42 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-06-30 16:36:50
 */
public class LexicographicallySmallestBeautifulString{
    public static void main(String[] args) {
        Solution solution = new LexicographicallySmallestBeautifulString().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestBeautifulString(String s, int k) {
        int index = s.length() - 1;
        k += 'a';
        char[] c = s.toCharArray();
        c[index]++;
        while (index < s.length()) {
            if (c[index] == k) {
                if (index == 0) {
                    return "";
                }
                c[index] = 'a';
                c[--index]++;
            } else if (index > 0 && c[index - 1] == c[index] || index > 1 && c[index - 2] == c[index]) {
                c[index]++;
            } else {
                index++;
            }
        }
        return new String(c);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}