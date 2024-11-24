//给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。 
//
// 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。 
//
// 
//
// 示例 1： 
//
// 输入：word = "b"
//输出：2
//解释：在 "b" 之前插入 "a" ，在 "b" 之后插入 "c" 可以得到有效字符串 "abc" 。
// 
//
// 示例 2： 
//
// 输入：word = "aaa"
//输出：6
//解释：在每个 "a" 之后依次插入 "b" 和 "c" 可以得到有效字符串 "abcabcabc" 。
// 
//
// 示例 3： 
//
// 输入：word = "abc"
//输出：0
//解释：word 已经是有效字符串，不需要进行修改。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 50 
// word 仅由字母 "a"、"b" 和 "c" 组成。 
// 
//
// Related Topics 栈 贪心 字符串 动态规划 👍 69 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;

/**
 * @author  YourName
 * @date 2024-01-11 20:59:38
 */
public class MinimumAdditionsToMakeValidString{
    public static void main(String[] args) {
        Solution solution = new MinimumAdditionsToMakeValidString().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int addMinimum(String word) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
             char c = word.charAt(i);
             if (c == 'a') {
                 if (!deque.isEmpty()) {
                     if (deque.getLast() == 'b') {
                         count++;
                     } else {
                         count += 2;
                     }
                     deque.clear();
                 }
             }
             if (c == 'b') {
                 if (!deque.isEmpty()) {
                     if (deque.getLast() == 'b') {
                         count += 2;
                     }
                     deque.clear();
                 } else {
                     count++;
                 }
             }
             if (c == 'c') {
                 if (deque.isEmpty()) {
                     count += 2;
                 } else if (deque.getLast() != 'b') {
                     count ++;
                 }
                 deque.clear();
                 continue;
             }
             deque.addLast(c);
        }
        if (!deque.isEmpty()) {
            if (deque.getLast() == 'b') {
                count++;
            } else {
                count += 2;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}