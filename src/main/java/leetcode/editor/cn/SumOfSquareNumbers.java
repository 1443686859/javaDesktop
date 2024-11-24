/**
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。 

 

 示例 1： 

 
输入：c = 5
输出：true
解释：1 * 1 + 2 * 2 = 5
 

 示例 2： 

 
输入：c = 3
输出：false
 

 

 提示： 

 
 0 <= c <= 2³¹ - 1 
 

 👍 464 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-11-04 00:41:15
 */
public class SumOfSquareNumbers{
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbers().new Solution();
        System.out.println(solution.judgeSquareSum(2147483646));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        while (a <= b) {
            if (a * a == c - b * b) {
                return true;
            }
            if (a * a < c - b * b) {
                a++;
            } else {
                b --;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}