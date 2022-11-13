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
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {
        List<Integer> currentList = new ArrayList<>();
        while (num != 0) {
            currentList.add(num % 10);
            num /= 10;
        }
        Collections.reverse(currentList);
        for (int i = 0; i < currentList.size(); i++) {
            int max = -1;
            int resultIndex = -1;
            for (int j = i + 1; j < currentList.size(); j++) {
                if (currentList.get(j) > currentList.get(i) && max < currentList.get(j)) {
                    max =currentList.get(j);
                    resultIndex = j;
                }
            }
            if (max != -1) {
                currentList.set(resultIndex, currentList.get(i));
                currentList.set(i, max);
                break;
            }
        }
        int result = 0;
        for (int i = 0; i < currentList.size(); i++) {
            result = result * 10 + currentList.get(i);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}