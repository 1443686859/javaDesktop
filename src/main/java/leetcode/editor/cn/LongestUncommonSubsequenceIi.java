//给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。 
//
// 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。 
//
// s 的 子序列可以通过删去字符串 s 中的某些字符实现。 
//
// 
// 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括
//"aebdc"、 "aeb" 和 "" (空字符串)。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: strs = ["aba","cdc","eae"]
//输出: 3
// 
//
// 示例 2: 
//
// 
//输入: strs = ["aaa","aaa","aa"]
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 2 <= strs.length <= 50 
// 1 <= strs[i].length <= 10 
// strs[i] 只包含小写英文字母 
// 
// Related Topics 数组 哈希表 双指针 字符串 排序 👍 145 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author  YourName
 * @date 2022-06-27 20:23:25
 */
public class LongestUncommonSubsequenceIi{
    public static void main(String[] args) {
        Solution solution = new LongestUncommonSubsequenceIi().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> {
            return b.length() - a.length();
        });
        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && check(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return strs[i].length();
            }
        }

        return -1;
    }
    public boolean check(String pre, String after) {
       int index = 0;
       for (char c : after.toCharArray()) {
           if (pre.charAt(index) == c && ++index == pre.length()) {
               return true;
           }
       }
       return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}