//给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 
//
// 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
// 
//
// 示例 2: 
//
// 
//输入: s = "3z4"
//输出: ["3z4","3Z4"]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 12 
// s 由小写英文字母、大写英文字母和数字组成 
// 
//
// Related Topics 位运算 字符串 回溯 👍 439 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-10-30 10:36:16
 */
public class LetterCasePermutation{
    public static void main(String[] args) {
        Solution solution = new LetterCasePermutation().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<String> result;
    public List<String> letterCasePermutation(String s) {
        result = new ArrayList<>();
        char[] charArray = s.toCharArray();
        dfs(0, charArray);
        return result;
    }
    public void dfs(int startIndex, char[] charArray) {
        if (startIndex == charArray.length) {
            result.add(new String(charArray));
            return;
        }
        if (Character.isLetter(charArray[startIndex])) {
            charArray[startIndex] = (char)(charArray[startIndex] ^ 32);
            dfs(startIndex + 1, charArray);
        }
        dfs(startIndex + 1,charArray);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}