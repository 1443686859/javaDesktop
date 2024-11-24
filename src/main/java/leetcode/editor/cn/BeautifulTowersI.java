//给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。 
//
// 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。 
//
// 如果以下条件满足，我们称这些塔是 美丽 的： 
//
// 
// 1 <= heights[i] <= maxHeights[i] 
// heights 是一个 山脉 数组。 
// 
//
// 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组： 
//
// 
// 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j] 
// 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k] 
// 
//
// 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：maxHeights = [5,3,4,1,1]
//输出：13
//解释：和最大的美丽塔方案为 heights = [5,3,3,1,1] ，这是一个美丽塔方案，因为：
//- 1 <= heights[i] <= maxHeights[i]  
//- heights 是个山脉数组，峰值在 i = 0 处。
//13 是所有美丽塔方案中的最大高度和。 
//
// 示例 2： 
//
// 
//输入：maxHeights = [6,5,3,9,2,7]
//输出：22
//解释： 和最大的美丽塔方案为 heights = [3,3,3,9,2,2] ，这是一个美丽塔方案，因为：
//- 1 <= heights[i] <= maxHeights[i]
//- heights 是个山脉数组，峰值在 i = 3 处。
//22 是所有美丽塔方案中的最大高度和。 
//
// 示例 3： 
//
// 
//输入：maxHeights = [3,2,5,5,2,3]
//输出：18
//解释：和最大的美丽塔方案为 heights = [2,2,5,5,2,2] ，这是一个美丽塔方案，因为：
//- 1 <= heights[i] <= maxHeights[i]
//- heights 是个山脉数组，最大值在 i = 2 处。
//注意，在这个方案中，i = 3 也是一个峰值。
//18 是所有美丽塔方案中的最大高度和。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n == maxHeights <= 10³ 
// 1 <= maxHeights[i] <= 10⁹ 
// 
//
// Related Topics 栈 数组 单调栈 👍 54 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-01-24 19:40:33
 */
public class BeautifulTowersI{
    public static void main(String[] args) {
        Solution solution = new BeautifulTowersI().new Solution();
        System.out.println(solution.maximumSumOfHeights(Arrays.asList(5,3,4,1,1)));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = maxHeights.size();
        long[] pre = new long[n];
        for (int i = 0; i < maxHeights.size(); i++) {
            while (!deque.isEmpty() && maxHeights.get(deque.getLast()) > maxHeights.get(i)) {
                deque.removeLast();
            }
            if (!deque.isEmpty()) {
                int last = deque.getLast();
                pre[i] = pre[last] + 1l * (i - last) * maxHeights.get(i);
            } else {
                pre[i] = 1l * (i + 1) * maxHeights.get(i);
            }
            deque.addLast(i);
        }
        long[] after = new long[n];
        deque.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && maxHeights.get(deque.getLast()) > maxHeights.get(i)) {
                deque.removeLast();
            }
            if (!deque.isEmpty()) {
                int last = deque.getLast();
                after[i] = after[last] + 1l * (last - i) * maxHeights.get(i);
            } else {
                after[i] = 1l * (n - i) * maxHeights.get(i);
            }
            deque.addLast(i);
        }
        long max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, pre[i] + after[i] - maxHeights.get(i));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}