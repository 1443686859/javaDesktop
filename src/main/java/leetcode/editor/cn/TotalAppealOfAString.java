//字符串的 引力 定义为：字符串中 不同 字符的数量。 
//
// 
// 例如，"abbca" 的引力为 3 ，因为其中有 3 个不同字符 'a'、'b' 和 'c' 。 
// 
//
// 给你一个字符串 s ，返回 其所有子字符串的总引力 。 
//
// 子字符串 定义为：字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abbca"
//输出：28
//解释："abbca" 的子字符串有：
//- 长度为 1 的子字符串："a"、"b"、"b"、"c"、"a" 的引力分别为 1、1、1、1、1，总和为 5 。
//- 长度为 2 的子字符串："ab"、"bb"、"bc"、"ca" 的引力分别为 2、1、2、2 ，总和为 7 。
//- 长度为 3 的子字符串："abb"、"bbc"、"bca" 的引力分别为 2、2、3 ，总和为 7 。
//- 长度为 4 的子字符串："abbc"、"bbca" 的引力分别为 3、3 ，总和为 6 。
//- 长度为 5 的子字符串："abbca" 的引力为 3 ，总和为 3 。
//引力总和为 5 + 7 + 7 + 6 + 3 = 28 。
// 
//
// 示例 2： 
//
// 输入：s = "code"
//输出：20
//解释："code" 的子字符串有：
//- 长度为 1 的子字符串："c"、"o"、"d"、"e" 的引力分别为 1、1、1、1 ，总和为 4 。
//- 长度为 2 的子字符串："co"、"od"、"de" 的引力分别为 2、2、2 ，总和为 6 。
//- 长度为 3 的子字符串："cod"、"ode" 的引力分别为 3、3 ，总和为 6 。
//- 长度为 4 的子字符串："code" 的引力为 4 ，总和为 4 。
//引力总和为 4 + 6 + 6 + 4 = 20 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 动态规划 👍 49 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-05-06 20:19:42
 */
public class TotalAppealOfAString{
    public static void main(String[] args) {
        Solution solution = new TotalAppealOfAString().new Solution();
        System.out.println(solution.appealSum("a"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long appealSum(String s) {
        int n = s.length();
        int[] index = new int[26];
        Arrays.fill(index, -1);
        long result = 0;
        long preResult = 0;
        for (int i = 0; i < n; i++) {
            long currentResult = 0;
            int currentIndex = s.charAt(i) - 'a';
            if (index[currentIndex] != -1) {
                int preIndex = index[currentIndex];
                currentResult = preResult + i - preIndex;
            } else {
               currentResult = preResult + i + 1;
            }
            index[currentIndex] = i;
            result += currentResult;
            preResult = currentResult;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}