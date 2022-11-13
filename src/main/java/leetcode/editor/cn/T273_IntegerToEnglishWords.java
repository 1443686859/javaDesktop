//将非负整数 num 转换为其对应的英文表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 123
//输出："One Hundred Twenty Three"
// 
//
// 示例 2： 
//
// 
//输入：num = 12345
//输出："Twelve Thousand Three Hundred Forty Five"
// 
//
// 示例 3： 
//
// 
//输入：num = 1234567
//输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// 
//
// 示例 4： 
//
// 
//输入：num = 1234567891
//输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven 
//Thousand Eight Hundred Ninety One"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 2³¹ - 1 
// 
// Related Topics 递归 数学 字符串 👍 225 👎 0


package leetcode.editor.cn;
//Java：整数转换英文表示
public class T273_IntegerToEnglishWords{
    public static void main(String[] args) {
        Solution solution = new T273_IntegerToEnglishWords().new Solution();
        // TO TEST
        System.out.println(solution.numberToWords(123));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuffer result = new StringBuffer();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= curNum * unit;
                StringBuffer current = new StringBuffer();
                recursion(current, curNum);
                current.append(thousands[i]);
                if (i > 0 && num != 0) {
                    current.append(" ");
                }
                result.append(current);
            }
        }
        return result.toString();
    }
    public void recursion(StringBuffer current, int num) {
        if (num == 0) {
            return;
        } else if (num < 10) {
            current.append(singles[num]);
        } else if (num < 20) {
            current.append(teens[num - 10]).append(" ");
        } else if (num < 100) {
            current.append(tens[num / 10]).append(" ");
            recursion(current, num % 10);
        } else {
            current.append(singles[num / 100]).append(" Hundred ");
            recursion(current, num % 100);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}