//我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表
//中。 
//
// 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数
//来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。 
//
// 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。 
//
// 
//
// 
//示例 1:
//输入: "(123)"
//输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
// 
//
// 
//示例 2:
//输入: "(00011)"
//输出:  ["(0.001, 1)", "(0, 0.011)"]
//解释: 
//0.0, 00, 0001 或 00.01 是不被允许的。
// 
//
// 
//示例 3:
//输入: "(0123)"
//输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 
//3)"]
// 
//
// 
//示例 4:
//输入: "(100)"
//输出: [(10, 0)]
//解释: 
//1.0 是不被允许的。
// 
//
// 
//
// 提示: 
//
// 
// 4 <= S.length <= 12. 
// S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。 
// 
//
// 
//
// Related Topics 字符串 回溯 👍 121 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author  YourName
 * @date 2022-11-07 19:32:27
 */
public class AmbiguousCoordinates{
    public static void main(String[] args) {
        Solution solution = new AmbiguousCoordinates().new Solution();
        System.out.println(solution.ambiguousCoordinates("(0123)"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> ambiguousCoordinates(String s) {
        String target = s.substring(1, s.length() - 1);
        Set<String> result = new HashSet<>();
        int index = target.length() - 1;
        while (index >= 0) {
            boolean isRight = false;
            String first = target.substring(0, index);
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != '0') {
                    isRight = true;
                }
            }
            if (!isRight && first.length() != 1) {
                index--;
                continue;
            }

            String second = target.substring(index);
            for (int i = 0; i < second.length(); i++) {
                if (second.charAt(i) != '0') {
                    isRight = true;
                }
            }
            if (!isRight && second.length() != 1) {
                index--;
                continue;
            }
            if (first.startsWith("0")  && first.endsWith("0") && first.length() != 1) {
                index--;
                continue;
            }
            if (second.startsWith("0")  && second.endsWith("0") && second.length() != 1) {
                index--;
                continue;
            }
            List<String> firstResult = getCurrentResult(first);
            List<String> secondResult = getCurrentResult(second);
            for (int i = 0; i < firstResult.size(); i++) {
                for (int j = 0; j < secondResult.size(); j++) {
                    result.add("(" + firstResult.get(i) + ", " + secondResult.get(j) + ")");
                }
            }
            index--;
        }
        return result.stream().collect(Collectors.toList());
    }

    public List<String> getCurrentResult(String s) {
        if (s.startsWith("0")) {
            if (s.length() == 1) {
                return Arrays.asList(s);
            }
            return Arrays.asList("0." + s.substring(1));
        }
        if (s.endsWith("0")) {
            return Arrays.asList(s);
        }
        List<String> resultList = new ArrayList<>();
        resultList.add(s);
        for (int i = s.length() - 1; i >= 1; i--) {
            resultList.add(s.substring(0, i) + "." + s.substring(i));
        }
        return resultList;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}