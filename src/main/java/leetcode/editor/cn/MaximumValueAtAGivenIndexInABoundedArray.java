//给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）： 
//
// 
// nums.length == n 
// nums[i] 是 正整数 ，其中 0 <= i < n 
// abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1 
// nums 中所有元素之和不超过 maxSum 
// nums[index] 的值被 最大化 
// 
//
// 返回你所构造的数组中的 nums[index] 。 
//
// 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4, index = 2,  maxSum = 6
//输出：2
//解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
// 
//
// 示例 2： 
//
// 输入：n = 6, index = 1,  maxSum = 10
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= maxSum <= 10⁹ 
// 0 <= index < n 
// 
//
// Related Topics 贪心 二分查找 👍 138 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en



/**
 * @author  YourName
 * @date 2023-01-04 20:21:13
 */
public class MaximumValueAtAGivenIndexInABoundedArray{
    public static void main(String[] args) {
        Solution solution = new MaximumValueAtAGivenIndexInABoundedArray().new Solution();
        System.out.println(solution.maxValue(3,
                0,
                815094800));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int right = maxSum;
        int left = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, index, maxSum, n)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
    public boolean check(long mid, int index, int sum, int n) {
        long currentSum = getCount(mid - 1, index) + getCount(mid, n - index);
       return currentSum <= sum;
    }
    public long getCount(long start, int length) {
        return start >= length ? (start + start - length + 1) * length / 2 : (start + 1) * start / 2 + length - start;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}