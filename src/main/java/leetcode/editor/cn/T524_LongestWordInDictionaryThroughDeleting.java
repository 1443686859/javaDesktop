//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。 
//
// 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 👍 236 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：通过删除字母匹配到字典里最长单词
public class T524_LongestWordInDictionaryThroughDeleting{
    public static void main(String[] args) {
        Solution solution = new T524_LongestWordInDictionaryThroughDeleting().new Solution();
        // TO TEST
        System.out.println(solution.findLongestWord("aaa", Arrays.asList("aaa","aa","a")));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String temp : dictionary) {
            if (isContain(s, temp)) {
                if (temp.length() > result.length()) {
                    result = temp;
                } else if (temp.length() == result.length() && temp.compareTo(result) < 0) {
                    result = temp;
                }
            }
        }
        return result;
    }
    public boolean isContain(String s, String temp) {
        int i = 0;
        int j = 0;
        while (j < temp.length() && i < s.length()) {
            if (s.charAt(i) == temp.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (i >= s.length() && j < temp.length()) {
            return false;
        } else {
            return true;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}