//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 662 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-05-08 18:23:59
 */
public class PermutationInString{
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        System.out.println(solution.checkInclusion("adc","dcda"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] count = new int[26];
        int n = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']--;
        }
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            int index = s2.charAt(right) - 'a';
             count[index]++;
             while (count[index] > 0) {
                 count[s2.charAt(left) - 'a']--;
                 left++;
             }
             if (right - left + 1 == n) {
                 return true;
             }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}