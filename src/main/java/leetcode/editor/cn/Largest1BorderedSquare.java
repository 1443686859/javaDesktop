//给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0
//。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//输出：9
// 
//
// 示例 2： 
//
// 输入：grid = [[1,1,0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 100 
// 1 <= grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 193 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-02-17 22:01:01
 */
public class Largest1BorderedSquare{
    public static void main(String[] args) {
        Solution solution = new Largest1BorderedSquare().new Solution();
        System.out.println(solution.largest1BorderedSquare(new int[][]{{
                1,1,1},{1,0,1},{1,1,1
        }}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] colCount = new int[n + 1][m];
        int[][] rowCount = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                colCount[i + 1][j] = colCount[i][j] + grid[i][j];
                rowCount[i][j + 1] =  rowCount[i][j] + grid[i][j];
            }
        }
        for (int d = Math.min(n, m); d > 0; d--) {
            for (int i = 0; i <= n - d; i++) {
                for (int j = 0; j <= m - d; j++) {
                    if (colCount[i + d][j] - colCount[i][j] == d &&
                            rowCount[i][j + d] - rowCount[i][j] == d &&
                            colCount[i + d][j + d - 1] - colCount[i][j + d - 1] == d &&
                            rowCount[i + d - 1][j + d] - rowCount[i + d - 1][j] == d) {
                        return d * d;
                    }
                }
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}