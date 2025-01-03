//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。 
//
// 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, 
//i + k)] 包含 两个端点的任意位置。 
//
// 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。 
//
// 请你返回你能得到的 最大得分 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-1,-2,4,-7,3], k = 2
//输出：7
//解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [10,-5,-2,4,0,3], k = 3
//输出：17
//解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, k <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 队列 数组 动态规划 单调队列 堆（优先队列） 👍 146 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author  YourName
 * @date 2024-02-05 00:01:13
 */
public class JumpGameVi{
    public static void main(String[] args) {
        Solution solution = new JumpGameVi().new Solution();
        System.out.println(solution.maxResult(new int[]{1,-1,-2,4,-7,3}, 2));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        result[0] = nums[0];

        for (int i = 1; i < n; i ++) {
            while (deque.getFirst() < i - k) {
                deque.removeFirst();
            }
            int index = deque.getFirst();
            result[i] = result[index] + nums[i];
            while (!deque.isEmpty() && result[deque.getLast()] < result[i]) {
                deque.removeLast();
            }
            deque.add(i);
        }
        return result[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}