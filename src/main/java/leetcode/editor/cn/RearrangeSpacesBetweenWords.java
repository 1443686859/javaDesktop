//给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 
//text 至少包含一个单词 。 
//
// 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也
//意味着返回的字符串应当与原 text 字符串的长度相等。 
//
// 返回 重新排列空格后的字符串 。 
//
// 
//
// 示例 1： 
//
// 输入：text = "  this   is  a sentence "
//输出："this   is   a   sentence"
//解释：总共有 9 个空格和 4 个单词。可以将 9 个空格平均分配到相邻单词之间，相邻单词间空格数为：9 / (4-1) = 3 个。
// 
//
// 示例 2： 
//
// 输入：text = " practice   makes   perfect"
//输出："practice   makes   perfect "
//解释：总共有 7 个空格和 3 个单词。7 / (3-1) = 3 个空格加上 1 个多余的空格。多余的空格需要放在字符串的末尾。
// 
//
// 示例 3： 
//
// 输入：text = "hello   world"
//输出："hello   world"
// 
//
// 示例 4： 
//
// 输入：text = "  walks  udp package   into  bar a"
//输出："walks  udp  package  into  bar  a "
// 
//
// 示例 5： 
//
// 输入：text = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 100 
// text 由小写英文字母和 ' ' 组成 
// text 中至少包含一个单词 
// 
//
// Related Topics 字符串 👍 72 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-09-07 21:44:13
 */
public class RearrangeSpacesBetweenWords{
    public static void main(String[] args) {
        Solution solution = new RearrangeSpacesBetweenWords().new Solution();
        System.out.println(solution.reorderSpaces( "  this   is  a sentence "));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorderSpaces(String text) {
        int count = 0;
        List<String> currentList = new ArrayList<>();
        for (int i = 0; i < text.length(); ) {
            if (text.charAt(i) == ' ') {
                while (i < text.length() && text.charAt(i) == ' ') {
                    i++;
                    count++;
                }

            } else {
                int start = i;
                while (i < text.length() && text.charAt(i) != ' ') {
                    i++;
                }
                currentList.add(text.substring(start, i));
            }
        }
        int currentSize = currentList.size();
        int spaceSize = count / Math.max(currentSize - 1, 1);
        int last = count % (Math.max(currentSize - 1, 1));
        String currentSpace = "";
        while (spaceSize -- > 0) {
            currentSpace += " ";
        }
        String result = String.join(currentSpace, currentList);
        result.trim();
        while (result.length() < text.length()) {
            result += " ";
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}