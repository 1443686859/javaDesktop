/**
如果一个整数能够被其各个数位上的数字之和整除，则称之为 哈沙德数（Harshad number）。给你一个整数 x 。如果 x 是 哈沙德数 ，则返回 x 各个
数位上的数字之和，否则，返回 -1 。 

 

 示例 1： 

 
 输入： x = 18 
 

 输出： 9 

 解释： 

 x 各个数位上的数字之和为 9 。18 能被 9 整除。因此 18 是哈沙德数，答案是 9 。 

 示例 2： 

 
 输入： x = 23 
 

 输出： -1 

 解释： 

 x 各个数位上的数字之和为 5 。23 不能被 5 整除。因此 23 不是哈沙德数，答案是 -1 。 

 

 提示： 

 
 1 <= x <= 100 
 

 👍 24 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-07-03 23:28:21
 */
public class HarshadNumber{
    public static void main(String[] args) {
        Solution solution = new HarshadNumber().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int temp = x;
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return (x % sum == 0) ? sum : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}