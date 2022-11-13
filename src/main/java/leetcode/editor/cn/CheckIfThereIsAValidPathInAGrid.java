//给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是： 
//
// 
// 1 表示连接左单元格和右单元格的街道。 
// 2 表示连接上单元格和下单元格的街道。 
// 3 表示连接左单元格和下单元格的街道。 
// 4 表示连接右单元格和下单元格的街道。 
// 5 表示连接左单元格和上单元格的街道。 
// 6 表示连接右单元格和上单元格的街道。 
// 
//
// 
//
// 你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径
//。该路径必须只沿着街道走。 
//
// 注意：你 不能 变更街道。 
//
// 如果网格中存在有效的路径，则返回 true，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[2,4,3],[6,5,2]]
//输出：true
//解释：如图所示，你可以从 (0, 0) 开始，访问网格中的所有单元格并到达 (m - 1, n - 1) 。
// 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[1,2,1],[1,2,1]]
//输出：false
//解释：如图所示，单元格 (0, 0) 上的街道没有与任何其他单元格上的街道相连，你只会停在 (0, 0) 处。
// 
//
// 示例 3： 
//
// 输入：grid = [[1,1,2]]
//输出：false
//解释：你会停在 (0, 1)，而且无法到达 (0, 2) 。
// 
//
// 示例 4： 
//
// 输入：grid = [[1,1,1,1,1,1,3]]
//输出：true
// 
//
// 示例 5： 
//
// 输入：grid = [[2],[2],[2],[2],[2],[2],[6]]
//输出：true
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
// 1 <= grid[i][j] <= 6 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 56 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2022-04-13 22:20:58
 */
public class CheckIfThereIsAValidPathInAGrid{
    public static void main(String[] args) {
        Solution solution = new CheckIfThereIsAValidPathInAGrid().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasValidPath(int[][] grid) {
        int temp = 0;
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0});
        while (!deque.isEmpty()) {
            int[] current = deque.pop();
            int x = current[0];
            int y = current[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                if ((x == m - 1 && y == n) || (x == m && y == n - 1)) {
                    return true;
                }
                return false;
            }
            if (grid[x][y] == 1) {
                if (temp == 0 || temp == 1) {
                    temp = 1;
                    deque.add(new int[]{x, y + 1});
                    continue;
                }
                if (temp != 1) {
                    return false;
                }
            } else if (grid[x][y] == 2) {
                if (temp == 0 || temp == 4) {
                    temp = 4;
                    deque.add(new int[]{x + 1, y});
                    continue;
                }
                if (temp != 4) {
                    return false;
                }
            }  else if (grid[x][y] == 3) {
                if (temp == 0 || temp == 1) {
                    temp = 4;
                    deque.add(new int[]{x + 1, y});
                    continue;
                }
                if (temp != 1) {
                    return false;
                }
            }  else if (grid[x][y] == 4) {
                if (temp == 0 || temp == 8) {
                    temp = 1;
                    deque.add(new int[]{x, y + 1});
                    continue;
                }
                if (temp != 8) {
                    return false;
                }
            }  else if (grid[x][y] == 5) {
                if (temp == 0 || temp == 1) {
                    temp = 8;
                    deque.add(new int[]{x - 1, y});
                    continue;
                }
                if (temp != 1) {
                    return false;
                }
            }  else if (grid[x][y] == 6) {
                if (temp == 0 || temp == 4) {
                    temp = 1;
                    deque.add(new int[]{x, y + 1});
                    continue;
                }
                if (temp != 4) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}