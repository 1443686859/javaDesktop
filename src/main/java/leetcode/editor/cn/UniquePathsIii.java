//在二维网格 grid 上，有 4 种类型的方格： 
//
// 
// 1 表示起始方格。且只有一个起始方格。 
// 2 表示结束方格，且只有一个结束方格。 
// 0 表示我们可以走过的空方格。 
// -1 表示我们无法跨越的障碍。 
// 
//
// 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。 
//
// 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//输出：2
//解释：我们有以下两条路径：
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2) 
//
// 示例 2： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
//输出：4
//解释：我们有以下四条路径： 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
//2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
//3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
//4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3) 
//
// 示例 3： 
//
// 输入：[[0,1],[2,0]]
//输出：0
//解释：
//没有一条路能完全穿过每一个空的方格一次。
//请注意，起始和结束方格可以位于网格中的任意位置。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length * grid[0].length <= 20 
// 
//
// Related Topics 位运算 数组 回溯 矩阵 👍 242 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-08-04 00:09:36
 */
public class UniquePathsIii{
    public static void main(String[] args) {
        Solution solution = new UniquePathsIii().new Solution();
        System.out.println(solution.uniquePathsIII(new int[][]{
                { 1,0,0,0},{0,0,0,0},{0,0,2,-1}
        }));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] directions = new int[][]{
                {0, -1}, {-1,0}, {0, 1}, {1, 0}
        };
        int result = 0;
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int[] used = new int[n];
        int j = 0;
        int[] start = new int[2];
        int[] end = new int[2];
        for (int[] g : grid) {
            for (int i = 0; i < g.length; i++) {
                if (g[i] == -1) {
                    used[j] |= 1 << (g.length - i - 1);
                }
                if (g[i] == 1) {
                    start[0] = j;
                    start[1] = i;
                    used[j] |= 1 << (g.length - i - 1);
                }
                if (g[i] == 2) {
                    end[0] = j;
                    end[1] = i;
                }
            }
            j++;
        }
        dfs(start, end, used, grid);
        return result;
    }

    public void dfs(int[] start, int[] end, int[] used, int[][] grid) {
        if (start[0] == end[0] && start[1] == end[1]) {
            boolean current = true;
            for (int i : used) {
                current &= i == (1 << grid[0].length) - 1;
            }
            if (current) {
                result++;
            }
            return;
        }
        for (int[] direction : directions) {
            int[] n = new int[2];
            n[0] = start[0] + direction[0];
            n[1] = start[1] + direction[1];
            if (n[1] >= grid[0].length || n[1] < 0 || n[0] >= grid.length || n[0] < 0 || grid[n[0]][n[1]] == -1 || (used[n[0]] & (1 << (grid[0].length - 1 - n[1]))) != 0) {
                continue;
            }
            used[n[0]] |= 1 << (grid[0].length - 1 - n[1]);
            dfs(n, end, used, grid);
            used[n[0]] -= 1 << (grid[0].length - 1 - n[1]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}