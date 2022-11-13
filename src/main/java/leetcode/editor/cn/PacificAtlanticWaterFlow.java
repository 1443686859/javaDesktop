//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。 
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。 
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 
//
// 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可
//流向大西洋 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// 示例 2： 
//
// 
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 443 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-04-27 20:48:06
 */
public class PacificAtlanticWaterFlow{
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] directions = {{-1,0}, {1,0},{0,-1},{0,1}};
     int m;
     int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n= heights[0].length;
        m = heights.length;
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            dfs(0, i , p, heights);
        }
        for (int j = 0; j < m; j++) {
            dfs(j, 0, p, heights);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n- 1, a, heights);
        }
        for (int i = 0; i < n; i++) {
            dfs(m- 1, i , a, heights);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] && a[i][j]) {
                    List<Integer> currentResult = new ArrayList<>();
                    currentResult.add(i);
                    currentResult.add(j);
                    result.add(currentResult);
                }
            }
        }
        return result;
    }
    public void dfs(int i, int j, boolean[][] result, int[][] height) {
        if (result[i][j]) {
            return ;
        }
        result[i][j] = true;
        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && nj >= 0 && ni < m && nj < n && height[i][j] <= height[ni][nj]) {
                dfs(ni, nj, result, height);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}