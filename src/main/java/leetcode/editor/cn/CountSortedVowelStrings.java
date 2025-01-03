//给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。 
//
// 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：5
//解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：15
//解释：仅由元音组成的 15 个字典序字符串为
//["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
//注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
// 
//
// 示例 3： 
//
// 
//输入：n = 33
//输出：66045
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 50 
// 
//
// Related Topics 数学 动态规划 组合数学 👍 136 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-03-29 19:21:52
 */
public class CountSortedVowelStrings{
    public static void main(String[] args) {
        Solution solution = new CountSortedVowelStrings().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countVowelStrings(int n) {
        int[] m = new int[5];
        Arrays.fill(m, 1);
        int result = 5;
        for (int i = n - 2; i >= 0; i --) {
            int temp = 0;
            for (int j = 4; j >= 0; j --) {
                for (int z = j - 1; z >= 0; z--) {
                    m[j] += m[z];
                }
                temp += m[j];
            }
            result = temp;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}