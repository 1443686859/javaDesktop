/**
给你两个整数 n 和 x 。你需要构造一个长度为 n 的 正整数 数组 nums ，对于所有 0 <= i < n - 1 ，满足 nums[i + 1] 大于
 nums[i] ，并且数组 nums 中所有元素的按位 AND 运算结果为 x 。 

 返回 nums[n - 1] 可能的 最小 值。 

 

 示例 1： 

 
 输入：n = 3, x = 4 
 

 输出：6 

 解释： 

 数组 nums 可以是 [4,5,6] ，最后一个元素为 6 。 

 示例 2： 

 
 输入：n = 2, x = 7 
 

 输出：15 

 解释： 

 数组 nums 可以是 [7,15] ，最后一个元素为 15 。 

 

 提示： 

 
 1 <= n, x <= 10⁸ 
 

 👍 43 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-08-22 20:25:54
 */
public class MinimumArrayEnd{
    public static void main(String[] args) {
        Solution solution = new MinimumArrayEnd().new Solution();
        System.out.println(solution.minEnd(2,7));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minEnd(int n, int x) {
        List<Integer> indexList = new ArrayList<>();
        int start = 0;
        long result = x;
        n--;
        while (x != 0) {
            if ((x & 1) == 0) {
                if ((n & 1) == 1) {
                    result |= 1L << start;
                }
                n >>= 1;
            }
            x >>= 1;
            start++;
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                result |= 1L << start;
            }
            start++;
            n >>= 1;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}