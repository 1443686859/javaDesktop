//有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。 
//
// 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。 
//
// 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[
//j]。 
//
// 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：s1 = "xx", s2 = "yy"
//输出：1
//解释：
//交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。 
//
// 示例 2： 
//
// 输入：s1 = "xy", s2 = "yx"
//输出：2
//解释：
//交换 s1[0] 和 s2[0]，得到 s1 = "yy"，s2 = "xx" 。
//交换 s1[0] 和 s2[1]，得到 s1 = "xy"，s2 = "xy" 。
//注意，你不能交换 s1[0] 和 s1[1] 使得 s1 变成 "yx"，因为我们只能交换属于两个不同字符串的字符。 
//
// 示例 3： 
//
// 输入：s1 = "xx", s2 = "xy"
//输出：-1
// 
//
// 示例 4： 
//
// 输入：s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 1000 
// s1, s2 只包含 'x' 或 'y'。 
// 
//
// Related Topics 贪心 数学 字符串 👍 108 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-02-25 10:59:51
 */
public class MinimumSwapsToMakeStringsEqual{
    public static void main(String[] args) {
        Solution solution = new MinimumSwapsToMakeStringsEqual().new Solution();
        System.out.println(solution.minimumSwap("xyxyy", "xxyyy"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumSwap(String s1, String s2) {
        int[] count = new int[2];
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count[s1.charAt(i) % 2] ++;
            }
        }
        int d = count[0] + count[1];
        return d % 2 == 1 ? -1 : d / 2 + count[0] % 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}