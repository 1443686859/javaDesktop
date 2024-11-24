/**
给你一个字符串 s 。 

 你的任务是重复以下操作删除 所有 数字字符： 

 
 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。 
 

 请你返回删除所有数字字符以后剩下的字符串。 

 

 示例 1： 

 
 输入：s = "abc" 
 

 输出："abc" 

 解释： 

 字符串中没有数字。
 

 示例 2： 

 
 输入：s = "cb34" 
 

 输出："" 

 解释： 

 一开始，我们对 s[2] 执行操作，s 变为 "c4" 。 

 然后对 s[1] 执行操作，s 变为 "" 。 

 

 提示： 

 
 1 <= s.length <= 100 
 s 只包含小写英文字母和数字字符。 
 输入保证所有数字都可以按以上操作被删除。 
 

 👍 27 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2024-09-05 20:47:12
 */
public class ClearDigits{
    public static void main(String[] args) {
        Solution solution = new ClearDigits().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String clearDigits(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
               result.deleteCharAt(result.length() - 1);
            } else {
                result.append(s.charAt(i));
            }
         }

        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}