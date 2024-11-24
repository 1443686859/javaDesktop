//给你一个整数数组 nums 和一个 正 整数 k 。你可以选择数组的任一 子序列 并且对其全部元素求和。 
//
// 数组的 第 k 大和 定义为：可以获得的第 k 个 最大 子序列和（子序列和允许出现重复） 
//
// 返回数组的 第 k 大和 。 
//
// 子序列是一个可以由其他数组删除某些或不删除元素排生而来的数组，且派生过程不改变剩余元素的顺序。 
//
// 注意：空子序列的和视作 0 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,4,-2], k = 5
//输出：2
//解释：所有可能获得的子序列和列出如下，按递减顺序排列：
//- 6、4、4、2、2、0、0、-2
//数组的第 5 大和是 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,-2,3,4,-10,12], k = 16
//输出：10
//解释：数组的第 16 大和是 10 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 1 <= k <= min(2000, 2ⁿ) 
// 
//
// Related Topics 数组 排序 堆（优先队列） 👍 98 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author  YourName
 * @date 2024-03-09 11:16:01
 */
public class FindTheKSumOfAnArray{
    public static void main(String[] args) {
        Solution solution = new FindTheKSumOfAnArray().new Solution();
        System.out.println(solution.kSum(new int[]{2,4,-2}, 5));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long kSum(int[] nums, int k) {
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                sum += nums[i];
            } else {
                nums[i] *= -1;
            }
        }
        Arrays.sort(nums);
        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        queue.offer(new long[]{0L, 0});
        while (k > 1) {
            long[] min = queue.poll();
            long minS = min[0];
            long minIndex = min[1];
            if (minIndex < n) {
                queue.offer(new long[]{minS + nums[(int)minIndex], minIndex + 1});
                if (minIndex > 0) {
                    queue.offer(new long[]{minS - nums[(int)minIndex - 1] + nums[(int)minIndex], minIndex + 1});
                }
            }
            k--;
        }
        return sum - queue.peek()[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}