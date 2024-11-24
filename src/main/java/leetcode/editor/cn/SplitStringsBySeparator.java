//给你一个字符串数组 words 和一个字符 separator ，请你按 separator 拆分 words 中的每个字符串。 
//
// 返回一个由拆分后的新字符串组成的字符串数组，不包括空字符串 。 
//
// 注意 
//
// 
// separator 用于决定拆分发生的位置，但它不包含在结果字符串中。 
// 拆分可能形成两个以上的字符串。 
// 结果字符串必须保持初始相同的先后顺序。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["one.two.three","four.five","six"], separator = "."
//输出：["one","two","three","four","five","six"]
//解释：在本示例中，我们进行下述拆分：
//
//"one.two.three" 拆分为 "one", "two", "three"
//"four.five" 拆分为 "four", "five"
//"six" 拆分为 "six" 
//
//因此，结果数组为 ["one","two","three","four","five","six"] 。 
//
// 示例 2： 
//
// 
//输入：words = ["$easy$","$problem$"], separator = "$"
//输出：["easy","problem"]
//解释：在本示例中，我们进行下述拆分：
//
//"$easy$" 拆分为 "easy"（不包括空字符串）
//"$problem$" 拆分为 "problem"（不包括空字符串）
//
//因此，结果数组为 ["easy","problem"] 。
// 
//
// 示例 3： 
//
// 
//输入：words = ["|||"], separator = "|"
//输出：[]
//解释：在本示例中，"|||" 的拆分结果将只包含一些空字符串，所以我们返回一个空数组 [] 。 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 20 
// words[i] 中的字符要么是小写英文字母，要么就是字符串 ".,|$#@" 中的字符（不包括引号） 
// separator 是字符串 ".,|$#@" 中的某个字符（不包括引号） 
// 
//
// Related Topics 数组 字符串 👍 25 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-01-20 19:23:41
 */
public class SplitStringsBySeparator{
    public static void main(String[] args) {
        Solution solution = new SplitStringsBySeparator().new Solution();
        System.out.println(solution.splitWordsBySeparator(Arrays.asList("$easy$","$problem$"), '$'));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();

        for (String current : words) {
            int start = 0;
            for (int i = 0; i < current.length(); i++) {
                char c = current.charAt(i); 
                if (c == separator) {
                    if (start != i) {
                        result.add(current.substring(start, i));
                    }
                    start = i + 1;
                }
            }
            if (start < current.length()) {
                result.add(current.substring(start, current.length()));
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}