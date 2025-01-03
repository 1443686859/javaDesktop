//给你一个数组 nums ，它包含若干正整数。 
//
// 一开始分数 score = 0 ，请你按照下面算法求出最后分数： 
//
// 
// 从数组中选择最小且没有被标记的整数。如果有相等元素，选择下标最小的一个。 
// 将选中的整数加到 score 中。 
// 标记 被选中元素，如果有相邻元素，则同时标记 与它相邻的两个元素 。 
// 重复此过程直到数组中所有元素都被标记。 
// 
//
// 请你返回执行上述算法后最后的分数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,1,3,4,5,2]
//输出：7
//解释：我们按照如下步骤标记元素：
//- 1 是最小未标记元素，所以标记它和相邻两个元素：[2,1,3,4,5,2] 。
//- 2 是最小未标记元素，所以标记它和左边相邻元素：[2,1,3,4,5,2] 。
//- 4 是仅剩唯一未标记的元素，所以我们标记它：[2,1,3,4,5,2] 。
//总得分为 1 + 2 + 4 = 7 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,3,5,1,3,2]
//输出：5
//解释：我们按照如下步骤标记元素：
//- 1 是最小未标记元素，所以标记它和相邻两个元素：[2,3,5,1,3,2] 。
//- 2 是最小未标记元素，由于有两个 2 ，我们选择最左边的一个 2 ，也就是下标为 0 处的 2 ，以及它右边相邻的元素：[2,3,5,1,3,2] 。
//- 2 是仅剩唯一未标记的元素，所以我们标记它：[2,3,5,1,3,2] 。
//总得分为 1 + 2 + 2 = 5 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// 👍 3 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.PriorityQueue;

/**
 * @author  YourName
 * @date 2023-03-19 16:12:52
 */
public class FindScoreOfAnArrayAfterMarkingAllElements{
    public static void main(String[] args) {
        Solution solution = new FindScoreOfAnArrayAfterMarkingAllElements().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) ->{
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        int n = nums.length;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            priorityQueue.add(new int[]{nums[i], i});
        }
        long result = 0;
        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            if (!used[current[1]]) {
                if (current[1] - 1>= 0) {
                    used[current[1] - 1] = true;
                }
                if (current[1] + 1 < n) {
                    used[current[1] + 1] = true;
                }
                result += current[0];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}