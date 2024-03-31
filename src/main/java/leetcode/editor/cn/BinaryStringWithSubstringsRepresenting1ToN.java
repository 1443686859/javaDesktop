//给定一个二进制字符串 s 和一个正整数 n，如果对于 [1, n] 范围内的每个整数，其二进制表示都是 s 的 子字符串 ，就返回 true，否则返回 
//false 。 
//
// 子字符串 是字符串中连续的字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0110", n = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "0110", n = 4
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] 不是 '0' 就是 '1' 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 字符串 👍 111 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashSet;
import java.util.Set;

/**
 * @author  YourName
 * @date 2023-05-11 21:18:32
 */
public class BinaryStringWithSubstringsRepresenting1ToN{
    public static void main(String[] args) {
        Solution solution = new BinaryStringWithSubstringsRepresenting1ToN().new Solution();
        System.out.println(solution.queryString("011010101010111101010101011111111111111111111111111111111110000000000000011111101010101001010101010101010101010101111010101010111111111111111111111111111111111100000000000000111111010101010010101010101010101010100", 1000000000));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean queryString(String s, int n) {
        Set<Integer> set = new HashSet<>();
        int length = s.length();
        int max = n;
        for (int i = 0; i < s.length(); i++) {
            if (max == 0) {
                break;
            }
            int start = 0;
            int right = i;
            while (start <= n && right < length) {
                start = (start << 1) | (s.charAt(right) - '0');
                if (start != 0 && start <= n && set.add(start)) {
                    max--;
                }
                right++;
            }
        }
        return max == 0;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}