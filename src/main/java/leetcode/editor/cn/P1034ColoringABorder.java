package leetcode.editor.cn;
//给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色
//。 
//
// 两个网格块属于同一 连通分量 需满足下述全部条件： 
//
// 
// 两个网格块颜色相同 
// 在上、下、左、右任意一个方向上相邻 
// 
//
// 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块： 
//
// 
// 在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻 
// 在网格的边界上（第一行/列或最后一行/列） 
// 
//
// 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
//输出：[[3,3],[3,2]] 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
//输出：[[1,3,3],[2,3,3]] 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
//输出：[[2,2,2],[2,1,2],[2,2,2]] 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j], color <= 1000 
// 0 <= row < m 
// 0 <= col < n 
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 112 👎 0

import java.util.LinkedList;
import java.util.Queue;

public class P1034ColoringABorder{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.colorBorder(new int[][]{{1,1,}, {1,2}}, 0 ,0 , 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    public int[][] directions = new int[][]{{0,1}, {0, -1}, {-1, 0}, {1, 0}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int length = grid.length;
        int width = grid[0].length;
        boolean[][] visited = new boolean[length][width];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int originColor = grid[row][col];
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            boolean isOff = false;
            for (int i = 0; i < directions.length; i++) {
                int[] temp = directions[i];
                int[] result = new int[2];
                result[0] = temp[0] + x;
                result[1] = temp[1] + y;
                if (!(result[0] >= 0 && result[0] < length && result[1] >= 0 && result[1] < width && grid[result[0]][result[1]] == originColor)) {
                    isOff = true;
                } else if (!visited[result[0]][result[1]]) {
                    queue.offer(result);
                    visited[result[0]][result[1]] = true;
                }
                if (isOff ) {
                    grid[x][y]  = color;
                }
            }
        }
        return grid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}