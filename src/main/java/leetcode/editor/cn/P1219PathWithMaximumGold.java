package leetcode.editor.cn;
//你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄
//金数量；如果该单元格是空的，那么就是 0。 
//
// 为了使收益最大化，矿工需要按以下规则来开采黄金： 
//
// 
// 每当矿工进入一个单元，就会收集该单元格中的所有黄金。 
// 矿工每次可以从当前位置向上下左右四个方向走。 
// 每个单元格只能被开采（进入）一次。 
// 不得开采（进入）黄金数目为 0 的单元格。 
// 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。 
// 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
//输出：24
//解释：
//[[0,6,0],
// [5,8,7],
// [0,9,0]]
//一种收集最多黄金的路线是：9 -> 8 -> 7。
// 
//
// 示例 2： 
//
// 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
//输出：28
//解释：
//[[1,0,7],
// [2,0,6],
// [3,4,5],
// [0,3,0],
// [9,0,20]]
//一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[i].length <= 15 
// 0 <= grid[i][j] <= 100 
// 最多 25 个单元格中有黄金。 
// 
// Related Topics 数组 回溯 矩阵 👍 127 👎 0

import java.util.ArrayDeque;
import java.util.Queue;

public class P1219PathWithMaximumGold{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaximumGold(new int[][]{{0,6,0},{5,8,7},{0,9,0}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    int[][] directions = new int[][]{
            {1, 0}, {-1, 0},{0,1},{0, -1}
    };
    int res = 0;
    int[][] grid;
    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    dfs(i, j, 0);
                }
            }
        }
        return res;
    }

    public void dfs(int x, int y, int currentResult) {

        int temp = grid[x][y];
        if (currentResult + temp > res) {
            res = currentResult + temp;
        }
        grid[x][y] = 0;
        for (int i = 0; i < directions.length; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];
            if  (nx < 0 || ny < 0 || ny >= grid[0].length || nx >= grid.length || grid[nx][ny] == 0) {
                continue;
            }
            dfs(nx, ny, currentResult + temp);
        }
        grid[x][y] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}