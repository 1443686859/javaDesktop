//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
//
// Related Topics 栈 字符串 👍 420 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2022-10-09 20:40:31
 */
public class ScoreOfParentheses{
    public static void main(String[] args) {
        Solution solution = new ScoreOfParentheses().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int result = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            int size = deque.size();
            if (size == 0) {
                countMap.clear();
            }
            if (c == '(') {
                deque.push(c);
            } else {
                if (countMap.containsKey(size + 1)) {
                    int nextResult = countMap.get(size + 1);
                    countMap.put(size, countMap.getOrDefault(size, 0) + 2 * nextResult);
                } else {
                    countMap.put(size,countMap.getOrDefault(size, 0) + 1);
                }
                deque.pop();
            }
            if (deque.size() == 0) {
                result += countMap.getOrDefault(1, 0);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}