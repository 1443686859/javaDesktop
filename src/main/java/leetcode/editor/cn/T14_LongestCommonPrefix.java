//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 1796 👎 0


package leetcode.editor.cn;
//Java：最长公共前缀
public class T14_LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new T14_LongestCommonPrefix().new Solution();
        // TO TEST
        System.out.println(solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
   /* public String longestCommonPrefix(String[] strs) {
        int minLength = strs[0].length();
        String minString = strs[0];
        for (String str : strs) {
            if (minLength > str.length()) {
                minString = str;
                minLength = str.length();
            }
        }
        String result = "";
        for (int i = 0; i < minLength; i++) {
            result = minString.substring(0, i + 1);
            boolean isContinue = true;
            for (String str : strs) {
                if (!str.startsWith(result)) {
                    isContinue = false;
                    break;
                }
            }
            if (!isContinue) {
                result = minString.substring(0, i);
                break;
            }
        }
        return result;
    }*/
   public String longestCommonPrefix(String[] strs) {
       if (strs == null || strs.length == 0) {
           return "";
       }
       int length = strs[0].length();
       int count = strs.length;
       for (int i = 0; i < length; i++) {
           char current = strs[0].charAt(i);
           for (int j = 1; j < count; j++) {
               if (i == strs[j].length() || current != strs[j].charAt(i)) {
                   return strs[0].substring(0, i);
               }
           }
       }
       return strs[0];
   }
}
//leetcode submit region end(Prohibit modification and deletion)

}