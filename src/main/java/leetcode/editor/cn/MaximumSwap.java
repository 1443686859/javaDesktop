//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 345 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-09-13 20:29:29
 */
public class MaximumSwap{
    public static void main(String[] args) {
        Solution solution = new MaximumSwap().new Solution();
        System.out.println(solution.maximumSwap(2736));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {
        List<Integer> result = new ArrayList<>();
        while (num != 0) {
            result.add(num % 10);
            num /= 10;
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
               if (result.get(maxIndex) <= result.get(j)) {
                   maxIndex = j;
               }
            }
            if (maxIndex != i && result.get(maxIndex) > result.get(i)) {
                int temp = result.get(i);
                result.set(i, result.get(maxIndex));
                result.set(maxIndex, temp);
                break;
            }
        }
        int ans = 0;
        for (int i = result.size() - 1; i >= 0; i--) {
            ans = ans * 10 + result.get(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}