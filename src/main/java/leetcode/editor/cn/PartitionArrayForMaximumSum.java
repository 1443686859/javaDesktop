//给你一个整数数组 arr，请你将该数组分隔为长度 最多 为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。 
//
// 返回将数组分隔变换后能够得到的元素最大和。本题所用到的测试用例会确保答案是一个 32 位整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,15,7,9,2,5,10], k = 3
//输出：84
//解释：数组变为 [15,15,15,9,10,10,10] 
//
// 示例 2： 
//
// 
//输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
//输出：83
// 
//
// 示例 3： 
//
// 
//输入：arr = [1], k = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 500 
// 0 <= arr[i] <= 10⁹ 
// 1 <= k <= arr.length 
// 
//
// Related Topics 数组 动态规划 👍 234 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2023-04-19 19:52:54
 */
public class PartitionArrayForMaximumSum{
    public static void main(String[] args) {
        Solution solution = new PartitionArrayForMaximumSum().new Solution();
        System.out.println(solution.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] memo;
        int k;
        int[] arr;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
        int n = arr.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        dfs(2);
        return memo[2];
    }
    public int dfs(int end) {
        if (end < 0) {
            return 0;
        }
        if (memo[end] != -1) {
            return memo[end];
        }
        int max = 0;
        int currentResult = 0;
        for (int j = end - 1; j >= Math.max(end - k, -1); j --) {
            max = Math.max(max, arr[j + 1]);
            currentResult = Math.max(currentResult, max * (end - j) + dfs(j));
        }
        memo[end] = currentResult;
        return currentResult;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}