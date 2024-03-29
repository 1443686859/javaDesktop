//给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤： 
//
// 
// 如果所读的字符是字母，则将该字母写在磁带上。 
// 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。 
// 
//
// 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。 
//
// 
//
// 示例 1： 
//
// 输入：S = "leet2code3", K = 10
//输出："o"
//解释：
//解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。
//字符串中的第 10 个字母是 "o"。
// 
//
// 示例 2： 
//
// 输入：S = "ha22", K = 5
//输出："h"
//解释：
//解码后的字符串为 "hahahaha"。第 5 个字母是 "h"。
// 
//
// 示例 3： 
//
// 输入：S = "a2345678999999999999999", K = 1
//输出："a"
//解释：
//解码后的字符串为 "a" 重复 8301530446056247680 次。第 1 个字母是 "a"。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= S.length <= 100 
// S 只包含小写字母与数字 2 到 9 。 
// S 以字母开头。 
// 1 <= K <= 10^9 
// 题目保证 K 小于或等于解码字符串的长度。 
// 解码后的字符串保证少于 2^63 个字母。 
// 
// Related Topics 栈 字符串 👍 166 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-04-19 21:59:52
 */
public class DecodedStringAtIndex{
    public static void main(String[] args) {
        Solution solution = new DecodedStringAtIndex().new Solution();
        System.out.println(solution.decodeAtIndex("leet2code3",10));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        int lastIndex = -1;
        // 获取到最后一个大于k的索引
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= c - '0';
            }else {
                size++;
            }
            if (size >= k) {
                break;
            }
            lastIndex++;
        }
        for (int i = lastIndex; i >= 0; i--) {
            char current = s.charAt(i);
            k %= size;
            if (k == 0 && Character.isLetter(current)) {
                return Character.toString(current);
            }
            if (Character.isDigit(current)) {
                size /= current - '0';
            } else {
                size --;
            }
        }
        throw null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}