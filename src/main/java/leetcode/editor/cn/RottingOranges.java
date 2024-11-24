/**
在给定的 m x n 网格
 grid 中，每个单元格可以有以下三个值之一： 

 
 值 0 代表空单元格； 
 值 1 代表新鲜橘子； 
 值 2 代表腐烂的橘子。 
 

 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 

 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 

 

 示例 1： 

 

 
输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
输出：4
 

 示例 2： 

 
输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
 

 示例 3： 

 
输入：grid = [[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 

 

 提示： 

 
 m == grid.length 
 n == grid[i].length 
 1 <= m, n <= 10 
 grid[i][j] 仅为 0、1 或 2 
 

 👍 869 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2024-05-13 18:42:33
 */
public class RottingOranges{
    public static void main(String[] args) {
        Solution solution = new RottingOranges().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        int oneCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    deque.addLast(new int[]{i, j});
                    grid[i][j] = 0;
                } else {
                    oneCount += grid[i][j];
                }
            }
        }
        int[][] d = new int[][]{{-1,0}, {1,0}, {0,1},{0,-1}};
        int count = 0;
        if (oneCount == 0) {
            return 0;
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] current = deque.pollFirst();
                for (int[] ne : d) {
                    int nx = current[0] + ne[0];
                    int ny = current[1] + ne[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n  && grid[nx][ny] == 1) {
                        deque.addLast(new int[]{nx, ny});
                        oneCount--;
                        grid[nx][ny] = 0;
                    }
                }
            }
            count++;
        }
        return oneCount != 0 ? -1 : (count == 0 ? 0 : count - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}