//给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。 
//
// 正整数的 各位数字之和 是其所有位上的对应数字相加的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 4
//输出：2
//解释：
//只有 2 和 4 满足小于等于 4 且各位数字之和为偶数。    
// 
//
// 示例 2： 
//
// 
//输入：num = 30
//输出：14
//解释：
//只有 14 个整数满足小于等于 30 且各位数字之和为偶数，分别是： 
//2、4、6、8、11、13、15、17、19、20、22、24、26 和 28 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 1000 
// 
//
// Related Topics 数学 模拟 👍 62 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-01-06 22:39:40
 */
public class CountIntegersWithEvenDigitSum{
    public static void main(String[] args) {
        Solution solution = new CountIntegersWithEvenDigitSum().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countEven(int num) {
        int x = num % 10;
        int y = num / 10;
        int ySum = 0;
        while (y != 0) {
            ySum += y % 10;
            y /= 10;
        }
        return (num / 10) * 5 + ((ySum & 1) == 0 ? x / 2 + 1 : (x + 1) / 2) - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}