//给你一个仅由 0 和 1 组成的二进制字符串 s 。 
//
// 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字
//符串。 
//
// 返回 s 中最长的平衡子字符串长度。 
//
// 子字符串是字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "01000111"
//输出：6
//解释：最长的平衡子字符串是 "000111" ，长度为 6 。
// 
//
// 示例 2： 
//
// 
//输入：s = "00111"
//输出：4
//解释：最长的平衡子字符串是 "0011" ，长度为  4 。
// 
//
// 示例 3： 
//
// 
//输入：s = "111"
//输出：0
//解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 50 
// '0' <= s[i] <= '1' 
// 
//
// Related Topics 字符串 👍 72 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-11-08 21:26:32
 */
public class FindTheLongestBalancedSubstringOfABinaryString{
    public static void main(String[] args) {
        Solution solution = new FindTheLongestBalancedSubstringOfABinaryString().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int index = 0;
        boolean user = false;
        int result = 0;
        int oneCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '0') {
                if (user) {
                    user = false;
                    index = i;
                }
                oneCount = 0;
            } else {
                user = true;
                oneCount ++;
                result = Math.max(result, 2 * Math.min(oneCount, i - index + 1 - oneCount));
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}