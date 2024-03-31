//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 示例 2： 
//
// 
//输入：hours = [6,6,6]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10⁴ 
// 0 <= hours[i] <= 16 
// 
//
// Related Topics 栈 数组 哈希表 前缀和 单调栈 👍 401 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-02-14 21:27:35
 */
public class LongestWellPerformingInterval{
    public static void main(String[] args) {
        Solution solution = new LongestWellPerformingInterval().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] sum = new int[n + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(0);
        for (int i = 0; i < n; i++) {
            sum[i + 1] += sum[i] + (hours[i] > 8 ? 1 : - 1);
            if (sum[i + 1] < sum[deque.peek()]) {
                deque.push(i + 1);
            }
        }
        int ans = 0;
        for (int i = n; i > 0; i--) {
            while (!deque.isEmpty() && sum[i] > sum[deque.peek()]) {
               ans = Math.max(ans, i - deque.poll() + 1);
            }

        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}