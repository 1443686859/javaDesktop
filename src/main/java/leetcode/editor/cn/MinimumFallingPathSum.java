//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。 
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 286 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-07-13 22:56:08
 */
public class MinimumFallingPathSum{
    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSum().new Solution();
        System.out.println(solution.minFallingPathSum(new int[][]{
                {2,1,3},{6,5,4},{7,8,9}
        }));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] result = matrix[0];
        for (int i = 1; i < n; i ++) {
            int[] current = new int[n];
            Arrays.fill(current, 10000);
            for (int j = 0; j < n; j++) {
                int min = Math.max(j - 1, 0);
                int max = Math.min(j + 1, n - 1);
                for (int z = min; z <= max; z++) {
                    current[j] = Math.min(current[j], result[z] + matrix[i][j]);
                }
            }
            result = current;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, result[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}