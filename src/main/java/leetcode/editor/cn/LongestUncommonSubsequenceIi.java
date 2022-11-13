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
        int result = -1;
        for (int i = 0; i < strs.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (check(strs[j], strs[i])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result = Math.max(result, strs[i].length());
            }

        }

        return result;
    }
    public boolean check(String pre, String after) {
        int startIndex1 = 0;
        int startIndex2 = 0;
        while (startIndex1 < pre.length() && startIndex2 < after.length()) {
            if (pre.charAt(startIndex1) != after.charAt(startIndex2)) {
                startIndex2++;
            } else {
                startIndex2++;
                startIndex1++;
            }
        }
        if (startIndex1 == pre.length()) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}