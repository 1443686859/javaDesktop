//给你一个正整数数组 arr，考虑所有满足以下条件的二叉树： 
//
// 
// 每个节点都有 0 个或是 2 个子节点。 
// 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。 
// 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。 
// 
//
// 在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个 32 位整数。 
//
// 如果一个节点有 0 个子节点，那么该节点为叶节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：arr = [6,2,4]
//输出：32
//解释：有两种可能的树，第一种的非叶节点的总和为 36 ，第二种非叶节点的总和为 32 。 
// 
//
// 示例 2： 
// 
// 
//输入：arr = [4,11]
//输出：44
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 40 
// 1 <= arr[i] <= 15 
// 答案保证是一个 32 位带符号整数，即小于 2³¹ 。 
// 
//
// Related Topics 栈 贪心 数组 动态规划 单调栈 👍 265 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-05-31 00:28:33
 */
public class MinimumCostTreeFromLeafValues{
    public static void main(String[] args) {
        Solution solution = new MinimumCostTreeFromLeafValues().new Solution();
        System.out.println(solution.mctFromLeafValues(new int[]{5,1,2,3,15,7,3,2,2,5,9,1,11,9,15,14,7,1,5}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][][] memo;
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        memo = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            memo[i][i] = new int[]{0, arr[i]};
        }
        return dfs(arr, 0, n - 1)[0];
    }

    public int[] dfs(int[] arr, int left, int right) {
        if (memo[left][right][1] != 0) {
            return memo[left][right];
        }
        int i = right;
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        for (; i > left; i--) {
            int[] leftResult = dfs(arr, left, i - 1);
            int[] rightResult = dfs(arr, i, right);
            result[0] = Math.min(result[0], leftResult[0] + rightResult[0] + (leftResult[1] * rightResult[1]));
            result[1] = Math.max(result[1], Math.max(leftResult[1], rightResult[1]));
        }
        memo[left][right] = result;

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}