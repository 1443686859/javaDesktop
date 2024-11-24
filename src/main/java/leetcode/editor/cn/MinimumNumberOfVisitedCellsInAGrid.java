//给你一个下标从 0 开始的 m x n 整数矩阵 grid 。你一开始的位置在 左上角 格子 (0, 0) 。 
//
// 当你在格子 (i, j) 的时候，你可以移动到以下格子之一： 
//
// 
// 满足 j < k <= grid[i][j] + j 的格子 (i, k) （向右移动），或者 
// 满足 i < k <= grid[i][j] + i 的格子 (k, j) （向下移动）。 
// 
//
// 请你返回到达 右下角 格子 (m - 1, n - 1) 需要经过的最少移动格子数，如果无法到达右下角格子，请你返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[3,4,2,1],[4,2,3,1],[2,1,0,0],[2,4,0,0]]
//输出：4
//解释：上图展示了到达右下角格子经过的 4 个格子。
// 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[3,4,2,1],[4,2,1,1],[2,1,1,0],[3,4,1,0]]
//输出：3
//解释：上图展示了到达右下角格子经过的 3 个格子。
// 
//
// 示例 3： 
//
// 
//
// 输入：grid = [[2,1,0],[1,0,0]]
//输出：-1
//解释：无法到达右下角格子。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 10⁵ 
// 0 <= grid[i][j] < m * n 
// grid[m - 1][n - 1] == 0 
// 
//
// Related Topics 栈 广度优先搜索 并查集 数组 动态规划 矩阵 单调栈 堆（优先队列） 👍 59 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-03-22 21:24:15
 */
public class MinimumNumberOfVisitedCellsInAGrid{
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfVisitedCellsInAGrid().new Solution();
        System.out.println(solution.minimumVisitedCells(new int[][]
                {{3,4,2,1},{4,2,3,1},{2,1,0,0},{2,4,0,0}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int min = 0;
        List<int[]>[] colStacks = new ArrayList[n];
        Arrays.setAll(colStacks, e -> new ArrayList<>());
        List<int[]> rowStacks = new ArrayList<>();
        for (int i = m - 1; i >= 0; i --) {
            rowStacks.clear();
            for (int j = n - 1; j>= 0; j--) {
                int g = grid[i][j];
                List<int[]> col = colStacks[j];
                min = i < m - 1 || j < n - 1 ? Integer.MAX_VALUE : 1;
                if (g > 0) {
                     int k = search(rowStacks, j + g);
                     if (k < rowStacks.size()) {
                         min = Math.min(min, rowStacks.get(k)[0] + 1);
                     }
                     k = search(col, i + g);
                     if (k < col.size()) {
                         min = Math.min(min, col.get(k)[0] + 1);
                     }
                }
                if (min < Integer.MAX_VALUE) {
                    while (!rowStacks.isEmpty() && min <= rowStacks.get(rowStacks.size() - 1)[0]) {
                        rowStacks.remove(rowStacks.size() - 1);
                    }
                    rowStacks.add(new int[]{min, j});
                    while (!col.isEmpty() && min <= col.get(col.size() - 1)[0]) {
                        col.remove(col.size() - 1);
                    }
                    col.add(new int[]{min, i});
                }
            }
        }
        return min < Integer.MAX_VALUE ? min : -1;

    }
    public int search(List<int[]> stack, int target) {
        int left = 0;
        int right = stack.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (stack.get(mid)[1] <= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}