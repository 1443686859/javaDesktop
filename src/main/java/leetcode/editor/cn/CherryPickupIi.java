/**
给你一个 rows x cols 的矩阵 grid 来表示一块樱桃地。 grid 中每个格子的数字表示你能获得的樱桃数目。 

 你有两个机器人帮你收集樱桃，机器人 1 从左上角格子 (0,0) 出发，机器人 2 从右上角格子 (0, cols-1) 出发。 

 请你按照如下规则，返回两个机器人能收集的最多樱桃数目： 

 
 从格子 (i,j) 出发，机器人可以移动到格子 (i+1, j-1)，(i+1, j) 或者 (i+1, j+1) 。 
 当一个机器人经过某个格子时，它会把该格子内所有的樱桃都摘走，然后这个位置会变成空格子，即没有樱桃的格子。 
 当两个机器人同时到达同一个格子时，它们中只有一个可以摘到樱桃。 
 两个机器人在任意时刻都不能移动到 grid 外面。 
 两个机器人最后都要到达 grid 最底下一行。 
 

 

 示例 1： 

 

 输入：grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
输出：24
解释：机器人 1 和机器人 2 的路径在上图中分别用绿色和蓝色表示。
机器人 1 摘的樱桃数目为 (3 + 2 + 5 + 2) = 12 。
机器人 2 摘的樱桃数目为 (1 + 5 + 5 + 1) = 12 。
樱桃总数为： 12 + 12 = 24 。
 

 示例 2： 

 

 输入：grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0
,2,3,0,0,6]]
输出：28
解释：机器人 1 和机器人 2 的路径在上图中分别用绿色和蓝色表示。
机器人 1 摘的樱桃数目为 (1 + 9 + 5 + 2) = 17 。
机器人 2 摘的樱桃数目为 (1 + 3 + 4 + 3) = 11 。
樱桃总数为： 17 + 11 = 28 。
 

 示例 3： 

 输入：grid = [[1,0,0,3],[0,0,0,3],[0,0,3,3],[9,0,3,3]]
输出：22
 

 示例 4： 

 输入：grid = [[1,1],[1,1]]
输出：4
 

 

 提示： 

 
 rows == grid.length 
 cols == grid[i].length 
 2 <= rows, cols <= 70 
 0 <= grid[i][j] <= 100 
 

 👍 112 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-05-07 21:26:33
 */
public class CherryPickupIi{
    public static void main(String[] args) {
        Solution solution = new CherryPickupIi().new Solution();
        System.out.println(solution.cherryPickup(new int[][]			{{1,0,0,0,0,0,1},{2,0,0,0,0,3,0},{2,0,9,0,0,0,0},{0,3,0,5,4,0,0},{1,0,2,3,0,0,6}}
                ));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] memo = new int[n + 1][grid[0].length][grid[0].length];
        for (int[][] m : memo) {
            for (int[] temp : m) {
                Arrays.fill(temp, -1);
            }
        }
        int result = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result = Math.max(dfs(n - 1, i, j, memo, grid) , result);
            }
        }
        return result;
    }
    public int dfs(int t, int j, int k, int[][][] memo, int[][] grid) {
        if (j < 0 || k < 0 || j >= grid[0].length || k >= grid[0].length) {
            return Integer.MIN_VALUE;
        }
        if (t == 0) {
            if (j == grid[0].length - 1 && k == 0 || (j == 0 && k == grid[0].length)) {
                return grid[0][0] + grid[0][grid[0].length - 1];
            } else {
                return Integer.MIN_VALUE;
            }

        }
        if (memo[t][j][k] != -1) {
            return memo[t][j][k];
        }
        int result = 0;
        for (int i = Math.max(0, j - 1); i <= Math.min(j + 1, grid[0].length - 1); i++) {
            for (int z = Math.max(0, k - 1); z <= Math.min(k + 1, grid[0].length - 1); z++) {
                result = Math.max(dfs(t - 1, i, z, memo, grid) + grid[t][j] + (j != k ? grid[t][k] : 0), result);
            }
        }
        memo[t][j][k] = result;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}