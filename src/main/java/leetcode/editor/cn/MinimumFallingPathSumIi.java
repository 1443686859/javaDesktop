//给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。 
//
// 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
//输出：13
//解释：
//所有非零偏移下降路径包括：
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
//下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[7]]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// -99 <= grid[i][j] <= 99 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 95 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author  YourName
 * @date 2023-08-10 00:00:22
 */
public class MinimumFallingPathSumIi{
    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSumIi().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] pre = new int[2][2];
        Arrays.fill(pre[0], Integer.MAX_VALUE);
        Arrays.fill(pre[1], Integer.MAX_VALUE);
        int[][] after;
        for (int i = 0; i < n; i++) {
           if (grid[0][i] < pre[0][1]) {
               pre[1][1] = pre[0][1];
               pre[1][0] = i;
               pre[0][1] = grid[0][i];
               pre[0][0] = i;
           } else if (grid[0][i] < pre[1][1]) {
               pre[1][1] = grid[0][i];
               pre[1][0] = i;
           }
        }
        for (int i = 1; i < n; i++) {
            after = new int[2][2];
            Arrays.fill(after[0], Integer.MAX_VALUE);
            Arrays.fill(after[1], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                int currentResult = grid[i][j] + (pre[0][0] == j ? pre[1][1] : pre[0][1]);
                if (currentResult < after[0][1]) {
                    after[1][1] = after[0][1];
                    after[1][0] = i;
                    after[0][1] = currentResult;
                    after[0][0] = j;
                } else if (currentResult < after[1][1]) {
                    after[1][1] = currentResult;
                    after[1][0] = j;
                }
            }
            pre = after;
        }
        return pre[0][1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}