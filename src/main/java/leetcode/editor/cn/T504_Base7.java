//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
// Related Topics 数学 👍 157 👎 0


package leetcode.editor.cn;
//Java：七进制数
public class T504_Base7{
    public static void main(String[] args) {
        Solution solution = new T504_Base7().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        boolean isPositive = true;
        if (num < 0) {
            isPositive = false;
        }
        num = Math.abs(num);
        while (num != 0) {
            result.insert(0,num % 7);
            num /= 7;
        }
        if (isPositive == false) {
            result.insert(0, "-");
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}