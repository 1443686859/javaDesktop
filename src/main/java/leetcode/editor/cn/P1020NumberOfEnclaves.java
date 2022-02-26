package leetcode.editor.cn;
//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。 
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 80 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P1020NumberOfEnclaves{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numEnclaves(new int[][] {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1},{0,-1}};
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        boolean[][] result = new boolean[m][n];
        Deque<int[]> startList = new ArrayDeque<>();
        for (int i = 0; i < m ; i++) {
            int[] current = new int[]{i, 0};
          if (grid[i][0] == 1 && !startList.contains(current)) {
              startList.add(current);
              result[i][0] = true;
          }
          int[] newCurrent = new int[] {i, n - 1};
            if (grid[i][n - 1] == 1 && !startList.contains(newCurrent)) {
                startList.add(newCurrent);
                result[i][n - 1] = true;
            }
        }
        for (int i = 0; i < n ; i++) {
            int[] current = new int[]{0, i};
            if (grid[0][i] == 1 && !startList.contains(current)) {
                startList.add(current);
                result[0][i] = true;
            }
            int[] newCurrent = new int[] {m - 1, i};
            if (grid[n - 1][i] == 1 && !startList.contains(newCurrent)) {
                startList.add(newCurrent);
                result[n - 1][i] = true;
            }
        }
        while (!startList.isEmpty()) {
                int[] current  = startList.poll();
                for (int i = 0; i < directions.length; i++) {
                    int nx = current[0] + directions[i][0];
                    int ny = current[1] + directions[i][1];
                    if (nx < 0 || nx >= result.length || ny < 0 || ny >= result[0].length || result[nx][ny] || grid[nx][ny] == 0) {
                        continue;
                    }
                    result[nx][ny] = true;
                    startList.add(new int[]{nx, ny});
                }

        }
        int enclaves = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !result[i][j]) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    class NewSolution {
        int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1},{0,-1}};
        public int numEnclaves(int[][] grid) {
            int m = grid.length;
            int n= grid[0].length;
            boolean[][] result = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                if (grid[i][0] == 1 && result[i][0] == false) {
                    result[i][0] = true;
                    dfs(new int[]{i, 0}, grid, result);
                }
                if (grid[i][n - 1] == 1 && result[i][n - 1] == false) {
                    result[i][n - 1] = true;
                    dfs(new int[]{i, n - 1}, grid, result);
                }
            }
            for (int j = 1; j < n - 1; j++) {
                if (grid[0][j] == 1 && result[0][j] == false) {
                    result[0][j] = true;
                    dfs(new int[]{0, j}, grid, result);
                }
                if (grid[m - 1][j] == 1 && result[m - 1][j] == false) {
                    result[m - 1][j] = true;
                    dfs(new int[]{m - 1, j}, grid, result);
                }
            }
            int enclaves = 0;
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (grid[i][j] == 1 && !result[i][j]) {
                        enclaves++;
                    }
                }
            }
            return enclaves;
        }
        public void  dfs(int[] current, int[][] grid, boolean[][] result)   {
            for (int i = 0; i < directions.length; i++) {
                int nx = current[0] + directions[i][0];
                int ny = current[1] + directions[i][1];
                if (nx < 0 || nx >= result.length || ny < 0 || ny >= result[0].length || result[nx][ny] || grid[nx][ny] == 0) {
                    continue;
                }
                result[nx][ny] = true;
                dfs(new int[]{nx, ny}, grid, result);
            }
        }
    }

}