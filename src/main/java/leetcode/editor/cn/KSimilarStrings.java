//对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。 
//
// 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab", s2 = "ba"
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：s1 = "abc", s2 = "bca"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length <= 20 
// s2.length == s1.length 
// s1 和 s2 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母 
// s2 是 s1 的一个字母异位词 
// 
//
// Related Topics 广度优先搜索 字符串 👍 235 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-09-21 21:25:07
 */
public class KSimilarStrings{
    public static void main(String[] args) {
        Solution solution = new KSimilarStrings().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int result = Integer.MAX_VALUE;
    public int kSimilarity(String s1, String s2) {
        return execute(s1.toCharArray(),s2.toCharArray(),0, 0);
    }
    public int execute(char[] s1, char[] s2, int start, int currentSum) {
        if (currentSum >= result) {
            return result;
        }
        if (start == s1.length - 1) {
            return result = Math.min(result, currentSum);
        }
        for (int i = start; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                for (int j = i + 1; j < s1.length; j++) {
                    if (s1[j] == s2[i] && s1[j] != s2[j]) {
                        swap(s1, i, j);
                        execute(s1, s2, i + 1, currentSum + 1);
                        swap(s1, i, j);
                        if (s1[i] == s2[j]) {
                            break;
                        }
                    }
                }
                return result;
            }
        }
        return result = Math.min(currentSum, result);
    }
    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}