//给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足： 
//
// 
// num1 和 num2 直接连起来，得到 num 各数位的一个排列。 
// 
//
// 
// 换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。 
// 
// 
// num1 和 num2 可以包含前导 0 。 
//
//
// 请你返回 num1 和 num2 可以得到的和的 最小 值。 
//
// 注意： 
//
// 
// num 保证没有前导 0 。 
// num1 和 num2 中数位顺序可以与 num 中数位顺序不同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 4325
//输出：59
//解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
// 
//
// 示例 2： 
//
// 
//输入：num = 687
//输出：75
//解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
// 
//
// 
//
// 提示： 
//
// 
// 10 <= num <= 10⁹ 
// 
//
// Related Topics 贪心 数学 排序 👍 21 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-10-09 00:13:05
 */
public class SplitWithMinimumSum{
    public static void main(String[] args) {
        Solution solution = new SplitWithMinimumSum().new Solution();
        System.out.println(solution.splitNum(13));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitNum(int num) {
        int[] count = new int[10];
        while (num != 0) {
            count[num % 10]++;
            num /= 10;
        }
        int pre = 0;
        int after = 0;
        int index = 0;
        int current = 0;
        while (index < count.length) {
            if (count[index] != 0) {
                if ((current & 1) == 0) {
                    pre = pre * 10 + index;
                } else {
                    after = after * 10 + index;
                }
                current++;
                count[index]--;
            } else {
                index++;
            }
        }
        return pre + after;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}