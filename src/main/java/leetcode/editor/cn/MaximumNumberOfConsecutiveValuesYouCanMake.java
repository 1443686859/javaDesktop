//给你一个长度为 n 的整数数组 coins ，它代表你拥有的 n 个硬币。第 i 个硬币的值为 coins[i] 。如果你从这些硬币中选出一部分硬币，它们的
//和为 x ，那么称，你可以 构造 出 x 。 
//
// 请返回从 0 开始（包括 0 ），你最多能 构造 出多少个连续整数。 
//
// 你可能有多个相同值的硬币。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1,3]
//输出：2
//解释：你可以得到以下这些值：
//- 0：什么都不取 []
//- 1：取 [1]
//从 0 开始，你可以构造出 2 个连续整数。 
//
// 示例 2： 
//
// 
//输入：coins = [1,1,1,4]
//输出：8
//解释：你可以得到以下这些值：
//- 0：什么都不取 []
//- 1：取 [1]
//- 2：取 [1,1]
//- 3：取 [1,1,1]
//- 4：取 [4]
//- 5：取 [4,1]
//- 6：取 [4,1,1]
//- 7：取 [4,1,1,1]
//从 0 开始，你可以构造出 8 个连续整数。 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,10,3,1]
//输出：20 
//
// 
//
// 提示： 
//
// 
// coins.length == n 
// 1 <= n <= 4 * 10⁴ 
// 1 <= coins[i] <= 4 * 10⁴ 
// 
//
// Related Topics 贪心 数组 👍 166 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-02-04 19:58:20
 */
public class MaximumNumberOfConsecutiveValuesYouCanMake{
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfConsecutiveValuesYouCanMake().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int ans = 0;
        for (int i : coins) {
            if (i > ans + 1) {
                break;
            } else {
                ans = i + 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}