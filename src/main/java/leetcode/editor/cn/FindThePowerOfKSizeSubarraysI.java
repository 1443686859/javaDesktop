/**
给你一个长度为 n 的整数数组 nums 和一个正整数 k 。 

 一个数组的 能量值 定义为： 

 
 如果 所有 元素都是依次 连续 且 上升 的，那么能量值为 最大 的元素。 
 否则为 -1 。 
 

 你需要求出 nums 中所有长度为 k 的 子数组 的能量值。 

 请你返回一个长度为 n - k + 1 的整数数组 results ，其中 results[i] 是子数组 nums[i..(i + k - 1)] 的能量值
。 

 

 示例 1： 

 
 输入：nums = [1,2,3,4,3,2,5], k = 3 
 

 输出：[3,4,-1,-1,-1] 

 解释： 

 nums 中总共有 5 个长度为 3 的子数组： 

 
 [1, 2, 3] 中最大元素为 3 。 
 [2, 3, 4] 中最大元素为 4 。 
 [3, 4, 3] 中元素 不是 连续的。 
 [4, 3, 2] 中元素 不是 上升的。 
 [3, 2, 5] 中元素 不是 连续的。 
 

 示例 2： 

 
 输入：nums = [2,2,2,2,2], k = 4 
 

 输出：[-1,-1] 

 示例 3： 

 
 输入：nums = [3,2,3,2,3,2], k = 2 
 

 输出：[-1,3,-1,3,-1] 

 

 提示： 

 
 1 <= n == nums.length <= 500 
 1 <= nums[i] <= 10⁵ 
 1 <= k <= n 
 

 👍 33 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2024-11-06 21:35:14
 */
public class FindThePowerOfKSizeSubarraysI{
    public static void main(String[] args) {
        Solution solution = new FindThePowerOfKSizeSubarraysI().new Solution();
        System.out.println();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.getFirst() < i - k + 1) {
                deque.removeFirst();
            }
            if (i != 0 && nums[i - 1] != nums[i] - 1 && k > 1) {
                deque.addLast(i - 1);
            }
            if (i >= k - 1) {
                result[i - k + 1] = !deque.isEmpty() ? - 1: nums[i];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}