//复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件： 
//
// 
// 实部 是一个整数，取值范围是 [-100, 100] 
// 虚部 也是一个整数，取值范围是 [-100, 100] 
// i² == -1 
// 
//
// 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "1+1i", num2 = "1+1i"
//输出："0+2i"
//解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
// 
//
// 示例 2： 
//
// 
//输入：num1 = "1+-1i", num2 = "1+-1i"
//输出："0+-2i"
//解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。 
// 
//
// 
//
// 提示： 
//
// 
// num1 和 num2 都是有效的复数表示。 
// 
// Related Topics 数学 字符串 模拟 👍 101 👎 0


package leetcode.editor.cn;
//Java：复数乘法
public class T537_ComplexNumberMultiplication{
    public static void main(String[] args) {
        Solution solution = new T537_ComplexNumberMultiplication().new Solution();
        // TO TEST
        System.out.println(solution.complexNumberMultiply("1+-1i","0+0i"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] num1s = num1.split("\\+");
        String[] num2s = num2.split("\\+");
        num1s[1] = num1s[1].split("i")[0].length() == 0 ? "1" : num1s[1].split("i")[0];
        num2s[1] = num2s[1].split("i")[0].length() == 0 ? "1" : num2s[1].split("i")[0];
        int a = Integer.valueOf(num1s[0]) * Integer.valueOf(num2s[0]);
        int b = Integer.valueOf(num1s[1]) * Integer.valueOf(num2s[0]) + Integer.valueOf(num1s[0]) * Integer.valueOf(num2s[1]);
        int c = Integer.valueOf(num1s[1]) * Integer.valueOf(num2s[1]);
        String result = (a - c) + "+" + (b) + "i";
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}