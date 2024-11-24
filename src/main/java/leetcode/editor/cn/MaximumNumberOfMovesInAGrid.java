//给你一个下标从 0 开始、大小为 m x n 的矩阵 grid ，矩阵由若干 正 整数组成。 
//
// 你可以从矩阵第一列中的 任一 单元格出发，按以下方式遍历 grid ： 
//
// 
// 从单元格 (row, col) 可以移动到 (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1) 
//三个单元格中任一满足值 严格 大于当前单元格的单元格。 
// 
//
// 返回你在矩阵中能够 移动 的 最大 次数。 
//
// 
//
// 示例 1： 
// 输入：grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
//输出：3
//解释：可以从单元格 (0, 0) 开始并且按下面的路径移动：
//- (0, 0) -> (0, 1).
//- (0, 1) -> (1, 2).
//- (1, 2) -> (2, 3).
//可以证明这是能够移动的最大次数。 
//
// 示例 2： 
//
// 
//输入：grid = [[3,2,4],[2,1,9],[1,1,7]]
//输出：0
//解释：从第一列的任一单元格开始都无法移动。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 2 <= m, n <= 1000 
// 4 <= m * n <= 10⁵ 
// 1 <= grid[i][j] <= 10⁶ 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 24 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-03-16 10:28:48
 */
public class MaximumNumberOfMovesInAGrid{
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfMovesInAGrid().new Solution();
        System.out.println(solution.maxMoves(new int[][]{{57,213,269,42,135,1,130,16,5,283,181,46,56,30},{170,260,222,279,276,50,182,264,256,255,233,82,300,19},{300,68,261,241,96,205,1,254,201,95,124,132,40,220},{212,38,50,38,176,271,109,27,83,195,165,7,180,224},{238,106,44,264,157,180,94,92,119,142,59,269,275,189},{35,34,226,241,45,195,200,178,104,92,255,170,49,91},{94,137,145,78,49,243,263,113,230,144,249,192,36,276},{271,241,12,126,232,192,294,212,239,199,49,106,177,104},{243,206,191,14,110,62,137,184,185,12,259,217,285,209},{124,197,299,299,4,36,245,160,182,300,7,170,50,67},{77,39,189,185,277,223,122,181,55,97,97,85,215,287},{124,42,198,38,204,87,172,9,102,232,112,71,186,296},{13,101,254,158,289,112,89,172,194,269,27,171,149,223}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            result[i][0] = 1;
        }
        int max = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[j][i] > grid[j][i - 1] && result[j][i - 1] != 0) {
                    result[j][i] = Math.max(result[j][i], result[j][i - 1] + 1);
                }
                if (j >= 1 && grid[j][i] > grid[j - 1][i - 1] && result[j - 1][i - 1] != 0) {
                    result[j][i] = Math.max(result[j][i], result[j - 1][i - 1] + 1);
                }
                if (j < n - 1 && grid[j][i] > grid[j + 1][i - 1] && result[j + 1][i - 1] != 0) {
                    result[j][i] = Math.max(result[j][i], result[j + 1][i - 1] + 1);
                }
                max = Math.max(max, result[j][i]);
            }
        }
        return Math.max(max - 1, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}