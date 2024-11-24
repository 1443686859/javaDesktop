/**
句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。如果单词的形式为美元符号后跟着一个非负实数，
那么这个单词就表示一个 价格 。 

 
 例如 "$100"、"$23" 和 "$6" 表示价格，而 "100"、"$" 和 "$1e5 不是。 
 

 给你一个字符串 sentence 表示一个句子和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该
单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。 

 返回表示修改后句子的字符串。 

 注意：所有价格 最多 为 10 位数字。 

 

 示例 1： 

 
输入：sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
输出："there are $0.50 $1.00 and 5$ candies in the shop"
解释：
表示价格的单词是 "$1" 和 "$2" 。 
- "$1" 减免 50% 为 "$0.50" ，所以 "$1" 替换为 "$0.50" 。
- "$2" 减免 50% 为 "$1" ，所以 "$1" 替换为 "$1.00" 。 

 示例 2： 

 
输入：sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$", discount = 100
输出："1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"
解释：
任何价格减免 100% 都会得到 0 。
表示价格的单词分别是 "$3"、"$5"、"$6" 和 "$9"。
每个单词都替换为 "$0.00"。
 

 

 提示： 

 
 1 <= sentence.length <= 10⁵ 
 sentence 由小写英文字母、数字、' ' 和 '$' 组成 
 sentence 不含前导和尾随空格 
 sentence 的所有单词都用单个空格分隔 
 所有价格都是 正 整数且不含前导零 
 所有价格 最多 为 10 位数字 
 0 <= discount <= 100 
 

 👍 34 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-06-18 22:28:45
 */
public class ApplyDiscountToPrices{
    public static void main(String[] args) {
        Solution solution = new ApplyDiscountToPrices().new Solution();
        System.out.println(solution.discountPrices("706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6", 28));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] strings = sentence.split(" ");
        List<String> temp = new ArrayList<>();
        for (String s : strings) {
            if (s.startsWith("$")) {
                StringBuilder stringBuilder = new StringBuilder();
                boolean isDigit = true;
                for (int i = 1; i < s.length(); i++) {
                    if (!Character.isDigit(s.charAt(i))) {
                        isDigit = false;
                    }
                    stringBuilder.append(s.charAt(i));
                }
                String result = stringBuilder.toString();
                if (isDigit && !stringBuilder.isEmpty()) {
                     result = String.format("%.2f", Long.parseLong(stringBuilder.toString()) *(100d - discount) / 100);
                }
                temp.add("$" + result);
            } else {
                temp.add(s);
            }
        }
        return String.join(" ", temp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}