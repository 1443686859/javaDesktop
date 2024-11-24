//给你一个长度为 n 的正整数数组 nums 和一个整数 k 。 
//
// 一开始，你的分数为 1 。你可以进行以下操作至多 k 次，目标是使你的分数最大： 
//
// 
// 选择一个之前没有选过的 非空 子数组 nums[l, ..., r] 。 
// 从 nums[l, ..., r] 里面选择一个 质数分数 最高的元素 x 。如果多个元素质数分数相同且最高，选择下标最小的一个。 
// 将你的分数乘以 x 。 
// 
//
// nums[l, ..., r] 表示 nums 中起始下标为 l ，结束下标为 r 的子数组，两个端点都包含。 
//
// 一个整数的 质数分数 等于 x 不同质因子的数目。比方说， 300 的质数分数为 3 ，因为 300 = 2 * 2 * 3 * 5 * 5 。 
//
// 请你返回进行至多 k 次操作后，可以得到的 最大分数 。 
//
// 由于答案可能很大，请你将结果对 109 + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [8,3,9,3,8], k = 2
//输出：81
//解释：进行以下操作可以得到分数 81 ：
//- 选择子数组 nums[2, ..., 2] 。nums[2] 是子数组中唯一的元素。所以我们将分数乘以 nums[2] ，分数变为 1 * 9 = 9 
//。
//- 选择子数组 nums[2, ..., 3] 。nums[2] 和 nums[3] 质数分数都为 1 ，但是 nums[2] 下标更小。所以我们将分数乘以
// nums[2] ，分数变为 9 * 9 = 81 。
//81 是可以得到的最高得分。 
//
// 示例 2： 
//
// 
//输入：nums = [19,12,14,6,10,18], k = 3
//输出：4788
//解释：进行以下操作可以得到分数 4788 ：
//- 选择子数组 nums[0, ..., 0] 。nums[0] 是子数组中唯一的元素。所以我们将分数乘以 nums[0] ，分数变为 1 * 19 = 1
//9 。
//- 选择子数组 nums[5, ..., 5] 。nums[5] 是子数组中唯一的元素。所以我们将分数乘以 nums[5] ，分数变为 19 * 18 = 
//342 。
//- 选择子数组 nums[2, ..., 3] 。nums[2] 和 nums[3] 质数分数都为 2，但是 nums[2] 下标更小。所以我们将分数乘以 
//nums[2] ，分数变为  342 * 14 = 4788 。
//4788 是可以得到的最高的分。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length == n <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 1 <= k <= min(n * (n + 1) / 2, 10⁹) 
// 
//
// 👍 18 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-08-14 23:35:10
 */
public class ApplyOperationsToMaximizeScore{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumScore(Arrays.asList(8,3,9,3,8), 2));
   }
//leetcode submit region begin(Prohibit modification and deletion)
 static class Solution {
        static int max = (int)1e5;
        static int[] count = new int[max + 1];
        int mod = (int)1e9 + 7;
         static {
             for (int i = 2; i <= max; i++) {
                 if (count[i] == 0) {
                     for (int j = i; j <= max; j += i) {
                         count[j]++;
                     }
                 }
             }
         }
    public int maximumScore(List<Integer> nums, int k) {
             int n = nums.size();
             int[] num = nums.stream().mapToInt(i -> i).toArray();
             int[] left = new int[n];
             int[] right = new int[n];
        Deque<Integer>  deque = new ArrayDeque<>();
        Arrays.fill(right, n);
        deque.push(-1);
        for (int i = 0; i < n; i++) {
            while (deque.size() > 1 && count[num[deque.peek()]] < count[num[i]]) {
                right[deque.pop()] = i;
            }
            left[i] = deque.peek();
            deque.push(i);
        }
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (pre, after) ->
            num[after] - num[pre]);
        long result = 1L;
        for (int i : index) {
            long currentCount = (long)(i - left[i]) * (right[i] - i);
            if (currentCount >= k) {
                result = result * fastPow(num[i], k) % mod;
                break;
            }
            result = result * fastPow(num[i], (int)currentCount) % mod;
            k -= currentCount;
        }
         return (int)result;
    }
    private long fastPow(long base, int k) {
             long result = 1L;
             while (k > 0) {
                 if ((k & 1) != 0) {
                     result = result * base % mod;
                 }
                 base = base * base % mod;
                 k >>= 1;
             }
             return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}