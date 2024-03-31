//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。 
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 示例 2： 
//
// 
//输入：arr = [11,81,94,43,3]
//输出：444
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
// 
//
// Related Topics 栈 数组 动态规划 单调栈 👍 551 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2022-10-28 21:46:51
 */
public class SumOfSubarrayMinimums{
    public static void main(String[] args) {
        Solution solution = new SumOfSubarrayMinimums().new Solution();
//        System.out.println(solution.sumSubarrayMins(new int[]{11,81,94,43,3}));
        System.out.println(solution.sumSubarrayMins(new int[]{4,21,26,35,50,61,68,82,88,92,97,90,85,79,68,50,50,33,22,15}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumSubarrayMins1(int[] arr) {
        int mod = (int)1e9 + 7;
        long result = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int n = arr.length;
        for (int i = 0; i <= n; i++) {
            int curr = i < n ? arr[i] : 0;
            while (!deque.isEmpty() && arr[deque.peek()] >= curr)  {
                int pop = deque.pop();
                int current = arr[pop];
                int left = deque.isEmpty() ? -1 : deque.peek();
                result += (long) current * (i - pop) * (pop - left);
            }
            deque.push(i);
        }
        return (int)(result % mod);
    }
    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        long result = 0;
        int n = arr.length;
        long[] dp = new long[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && arr[deque.peek()] >= arr[i])  {
                deque.pop();
            }
            int left = deque.isEmpty() ? - 1 : deque.peek();
            dp[i] = (long)arr[i] *(i - left) + (left == - 1 ? 0 : dp[left]);
            result = (result + dp[i]) % mod;
            deque.push(i);
        }
        return (int)result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}