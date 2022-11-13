//在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 
//grid[xi][yi] == 0 
//
// 返回 grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。 
//
// 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，
//由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: n = 5, mines = [[4, 2]]
//输出: 2
//解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
// 
//
// 示例 2： 
//
// 
//
// 
//输入: n = 1, mines = [[0, 0]]
//输出: 0
//解释: 没有加号标志，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 500 
// 1 <= mines.length <= 5000 
// 0 <= xi, yi < n 
// 每一对 (xi, yi) 都 不重复 
// 
//
// Related Topics 数组 动态规划 👍 181 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-11-09 21:19:25
 */
public class LargestPlusSign{
    public static void main(String[] args) {
        Solution solution = new LargestPlusSign().new Solution();
        System.out.println(solution.orderOfLargestPlusSign(10, new int[][]{
                {0,0},{0,1},{0,2},{0,7},
                {1,2},{1,3},{1,9},
                {2,3},{2,5},{2,7},{2,8},
                {3,2},{3,5},{3,7},
                {4,2},{4,3},{4,5},{4,7},
                {5,1},{5,4},{5,8},{5,9},
                {7,2},{7,5},{7,7},{7,8},
                {8,5},{8,8},
                {9,0},{9,1},{9,2},{9,8}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] col = new int[n][n];
        int[][] row = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(col[i], 1);
            Arrays.fill(row[i], 1);
        }
        for (int[] mine : mines) {
            col[mine[0]][mine[1]] = 0;
            row[mine[0]][mine[1]] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (col[j][i] != 0) {
                    col[j][i] = col[j - 1][i] + 1;
                }
                if (row[i][j] != 0) {
                    row[i][j] = row[i][j - 1] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if (col[i][j] == 0 || row[i][j] == 0) {
                    continue;
                }
                int north = col[i][j] - 1;
                int left = row[i][j] - 1;
                if (north < 0 || left < 0) {
                    continue;
                }
                int currentResult = Math.min(left, north);
                int min = Math.min(n - 1 - i, n - 1 - j);
                currentResult = Math.min(min, currentResult);
                while (currentResult >= 0) {
                    int nx = i + currentResult;
                    int ny = j + currentResult;
                    if (col[nx][j] - col[i][j] == currentResult && row[i][ny] - row[i][j] == currentResult) {
                        break;
                    }
                    currentResult--;
                }
                max = Math.max(max, currentResult + 1);
            }
        }
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}