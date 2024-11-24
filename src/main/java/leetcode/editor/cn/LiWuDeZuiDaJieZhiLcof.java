//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 446 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-03-08 21:44:59
 */
public class LiWuDeZuiDaJieZhiLcof{
    public static void main(String[] args) {
        Solution solution = new LiWuDeZuiDaJieZhiLcof().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        Integer[][] meno;
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] result = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                result[j] = Math.max(result[j], result[j - 1]) + grid[i - 1][j - 1];
            }
        }
        return result[m];
    }
    public int max(int[][] grid) {
        return dfs(grid, grid.length - 1, grid[0].length - 1);
    }
    public int dfs(int[][] grid, int i, int j) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (meno[i][j] != null) {
            return meno[i][j];
        }
        int result = Math.max(dfs(grid, i - 1, j), dfs(grid, i, j - 1)) + grid[i][j];
        meno[i][j] = result;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}