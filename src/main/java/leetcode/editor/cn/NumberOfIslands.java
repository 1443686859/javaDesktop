//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ['1','1','1','1','0'],
//  ['1','1','0','1','0'],
//  ['1','1','0','0','0'],
//  ['0','0','0','0','0']
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ['1','1','0','0','0'],
//  ['1','1','0','0','0'],
//  ['0','0','1','0','0'],
//  ['0','0','0','1','1']
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1825 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2022-07-29 22:11:20
 */
public class NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        System.out.println(solution.numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] parent;
    int result;
    public int numIslands(char[][] grid) {
        result = 0;
        int m =  grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    parent[i * n + j] = i * n + j;
                    result++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1')  {
                    grid[i][j] = '0';
                    int index = i * n + j;
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        union((i + 1) * n + j, index);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        union(index + 1, index);
                    }
                }
            }
        }
        return result;
    }
    public int find(int i) {
        while (i != parent[i]) {
            i = find(parent[i]);
        }
        return parent[i];
    }
    public void union(int i, int j) {
        int parentI = find(i);
        int parentJ = find(j);
        if (parentI != parentJ) {
            parent[parentI] = parentJ;
            result--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}