//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

package com.cute.leetcode.editor.cn;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid(""));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if (s.length() == 0) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char result = 'a';
            switch (c) {
                case '[':;
                case '{':;
                case '(': stack.push(c); break;
                case ']':
                    if (!stack.empty()) {
                        result = stack.pop();
                    } else {
                        return false;
                    }
                    if (result != '[') {
                        return false;
                    } else {
                        break;
                    }
                case '}':
                    if (!stack.empty()) {
                        result = stack.pop();
                    } else {
                        return false;
                    }
                    if (result != '{') {
                        return false;
                    } else {
                        break;
                    }
                case ')':
                    if (!stack.empty()) {
                        result = stack.pop();
                    } else {
                        return false;
                    }
                    if (result != '(') {
                        return false;
                    } else {
                        break;
                    }
            }
        }
        if (!stack.empty()) {
            return false;
        } else {
            return true;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}