//给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。 
//
// 一个子数组指的是原数组中连续的一个子序列。 
//
// 请你返回满足题目要求的最短子数组的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,10,4,2,3,5]
//输出：3
//解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
//另一个正确的解为删除子数组 [3,10,4] 。 
//
// 示例 2： 
//
// 
//输入：arr = [5,4,3,2,1]
//输出：4
//解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
// 
//
// 示例 3： 
//
// 
//输入：arr = [1,2,3]
//输出：0
//解释：数组已经是非递减的了，我们不需要删除任何元素。
// 
//
// 示例 4： 
//
// 
//输入：arr = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// 0 <= arr[i] <= 10^9 
// 
//
// Related Topics 栈 数组 双指针 二分查找 单调栈 👍 184 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2023-03-25 22:36:15
 */
public class ShortestSubarrayToBeRemovedToMakeArraySorted{
    public static void main(String[] args) {
        Solution solution = new ShortestSubarrayToBeRemovedToMakeArraySorted().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n];
        int[] after = new int[n];
        pre[0] = 1;
        after[n - 1] = 1;
        for (int i = 1; i < n; i ++) {
            if (arr[i] >= arr[i - 1]) {
                pre[i] = pre[i - 1] +1;
            } else {
                pre[i] = 1;
            }
            if (arr[n - 1 - i] <= arr[n - i]) {
                after[n - 1 - i] = after[n - i] +1;
            } else {
                after[n - 1 - i] = 1;
            }

        }
        Deque<Integer> deque = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (pre[i] + after[i] - 1 == n) {
                return n;
            }
            while (!deque.isEmpty() && arr[deque.getLast()] > arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}