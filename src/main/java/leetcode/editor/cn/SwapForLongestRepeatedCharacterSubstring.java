//如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。 
//
// 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。 
//
// 
//
// 示例 1： 
//
// 输入：text = "ababa"
//输出：3
// 
//
// 示例 2： 
//
// 输入：text = "aaabaaa"
//输出：6
// 
//
// 示例 3： 
//
// 输入：text = "aaabbaaa"
//输出：4
// 
//
// 示例 4： 
//
// 输入：text = "aaaaa"
//输出：5
// 
//
// 示例 5： 
//
// 输入：text = "abcdef"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 20000 
// text 仅由小写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 163 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-06-03 19:28:43
 */
public class SwapForLongestRepeatedCharacterSubstring{
    public static void main(String[] args) {
        Solution solution = new SwapForLongestRepeatedCharacterSubstring().new Solution();
        System.out.println(solution.maxRepOpt1("ababa"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxRepOpt1(String text) {
        int left = 0;
        int[] charCount = new int[26];
        int result = 0;
        for (Character c : text.toCharArray()) {
            charCount[c - 'a']++;
        }
        List<Integer> set = new ArrayList<>();
        int[] currentCount = new int[26];
        for (int i = 0; i < text.length(); i++) {
            int index = text.charAt(i) - 'a';
            if (currentCount[index] == 0) {
                set.add(index);
            }
            currentCount[index]++;
            while (check(set, currentCount, charCount)) {
                int leftIndex = text.charAt(left) - 'a';
                currentCount[leftIndex]--;
                if (currentCount[leftIndex] == 0) {
                   set.remove(Integer.valueOf(leftIndex));
                }
                left++;
            }
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
    public boolean check(List<Integer> set, int[] currentCount, int[] totalCount) {
        if (set.size() >= 3) {
            return true;
        }
        if (set.size() == 2) {
            int pre = set.get(0);
            int after = set.get(1);
            return !(totalCount[pre] - currentCount[pre] >= 1 && currentCount[after] == 1 || totalCount[after] - currentCount[after] >= 1 && currentCount[pre] == 1);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}