//全字母句 指包含英语字母表中每个字母至少一次的句子。 
//
// 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。 
//
// 如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
//输出：true
//解释：sentence 包含英语字母表中每个字母至少一次。
// 
//
// 示例 2： 
//
// 
//输入：sentence = "leetcode"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= sentence.length <= 1000 
// sentence 由小写英语字母组成 
// 
//
// Related Topics 哈希表 字符串 👍 59 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author  YourName
 * @date 2022-12-13 21:11:55
 */
public class CheckIfTheSentenceIsPangram{
    public static void main(String[] args) {
        Solution solution = new CheckIfTheSentenceIsPangram().new Solution();
        System.out.println(solution.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfPangram(String sentence) {
        int result = 0;
        for (int i = 0; i < sentence.length(); i++) {
            int index = sentence.charAt(i) - 'a';
            if ((result & (1 << index)) == 0) {
                result |= (1 << index);
            }
        }

        return result == (1 << 26) - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}