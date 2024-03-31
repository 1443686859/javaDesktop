//给你字符串 s 和整数 k 。 
//
// 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。 
//
// 英文中的 元音字母 为（a, e, i, o, u）。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abciiidef", k = 3
//输出：3
//解释：子字符串 "iii" 包含 3 个元音字母。
// 
//
// 示例 2： 
//
// 输入：s = "aeiou", k = 2
//输出：2
//解释：任意长度为 2 的子字符串都包含 2 个元音字母。
// 
//
// 示例 3： 
//
// 输入：s = "leetcode", k = 3
//输出：2
//解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
// 
//
// 示例 4： 
//
// 输入：s = "rhythms", k = 4
//输出：0
//解释：字符串 s 中不含任何元音字母。
// 
//
// 示例 5： 
//
// 输入：s = "tryhard", k = 4
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s 由小写英文字母组成 
// 1 <= k <= s.length 
// 
//
// Related Topics 字符串 滑动窗口 👍 56 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-12-16 19:46:11
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength{
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfVowelsInASubstringOfGivenLength().new Solution();
        System.out.println(solution.maxVowels("amqlgjitwetesmbbymgjbufptuspnduwsqxmqdvkydwipwllbktrseugnob", 31));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int[] count = new int[n + 1];
        List<Character> characterList = Arrays.asList('a', 'e','i' ,'o', 'u');
        for (int i = 0; i < n; i++) {
            count[i + 1] = count[i];
            if (characterList.contains(s.charAt(i))) {
                count[i + 1]++;
            }
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = Math.max(result, count[i + 1]);
        }
        for (int i = k; i < n; i++) {
            result = Math.max(result, count[i + 1] - count[i - k + 1]);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}