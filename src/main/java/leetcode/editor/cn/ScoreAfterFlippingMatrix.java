//给你一个大小为 m x n 的二元矩阵 grid ，矩阵中每个元素的值为 0 或 1 。 
//
// 一次 移动 是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。 
//
// 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的 得分 就是这些数字的总和。 
//
// 在执行任意次 移动 后（含 0 次），返回可能的最高分数。 
//
// 
//
// 
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 20 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 贪心 位运算 数组 矩阵 👍 236 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-05-02 19:49:40
 */
public class ScoreAfterFlippingMatrix{
    public static void main(String[] args) {
        Solution solution = new ScoreAfterFlippingMatrix().new Solution();
        System.out.println(solution.matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int matrixScore(int[][] grid) {
        int[] base = new int[grid.length];
        int[] col = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            base[i] = 0;
            for (int j = 0; j < grid[i].length; j++) {
                base[i] = base[i] * 2 + grid[i][j];
                col[j] += grid[i][j];
            }
            int currentResult = ((1 << grid[i].length) - 1) & (~ base[i]);
            if (currentResult > base[i]) {
                base[i] = currentResult;
                for (int j = 0; j < grid[i].length; j++) {
                    col[j] += grid[i][j] == 0 ? 1 : -1;
                    grid[i][j] = 1 ^ grid[i][j];
                }
            }
        }
        for (int i = 0; i < col.length; i++) {
            if (2 * col[i] < grid.length) {
                for (int j = 0; j < grid.length; j++) {
                    if (grid[j][i] == 0) {
                        base[j] |= 1 << (col.length - 1 - i);
                    } else {
                        base[j] -= 1 << (col.length - 1- i);
                    }
                }
            }
        }
        int currentResult = 0;
        for (int i = 0; i < grid.length; i++) {
            currentResult += base[i];
        }
        return currentResult;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}