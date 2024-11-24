/**
给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的字典序最小的字符串。 

 如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。 

 

 示例 1： 

 
 输入： s = "45320" 
 

 输出： "43520" 

 解释： 

 s[1] == '5' 和 s[2] == '3' 都具有相同的奇偶性，交换它们可以得到字典序最小的字符串。 

 示例 2： 

 
 输入： s = "001" 
 

 输出： "001" 

 解释： 

 无需进行交换，因为 s 已经是字典序最小的。 

 

 提示： 

 
 2 <= s.length <= 100 
 s 仅由数字组成。 
 

 👍 23 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-10-30 21:56:07
 */
public class LexicographicallySmallestStringAfterASwap{
    public static void main(String[] args) {
        Solution solution = new LexicographicallySmallestStringAfterASwap().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getSmallestString(String s) {
        int index = 1;
        char[] chars = s.toCharArray();
        int count = 1;
        for (; index < s.length(); index++) {
            int pre = s.charAt(index - 1) - '0';
            int current = s.charAt(index) - '0';
            if ((current & 1) == (pre & 1) && current < pre && count >= 1) {
                chars[index - 1] = (char) ('0' + current);
                chars[index] = (char) ('0' + pre);
                count--;
            }
        }
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}