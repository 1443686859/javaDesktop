//「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。 
//
// 游戏地图用大小为 m x n 的网格 grid 表示，其中每个元素可以是墙、地板或者是箱子。 
//
// 现在你将作为玩家参与游戏，按规则将箱子 'B' 移动到目标位置 'T' ： 
//
// 
// 玩家用字符 'S' 表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。 
// 地板用字符 '.' 表示，意味着可以自由行走。 
// 墙用字符 '#' 表示，意味着障碍物，不能通行。 
// 箱子仅有一个，用字符 'B' 表示。相应地，网格上有一个目标位置 'T'。 
// 玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。 
// 玩家无法越过箱子。 
// 
//
// 返回将箱子推到目标位置的最小 推动 次数，如果无法做到，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [["#","#","#","#","#","#"],
//             ["#","T","#","#","#","#"],
//             ["#",".",".","B",".","#"],
//             ["#",".","#","#",".","#"],
//             ["#",".",".",".","S","#"],
//             ["#","#","#","#","#","#"]]
//输出：3
//解释：我们只需要返回推箱子的次数。 
//
// 示例 2： 
//
// 
//输入：grid = [["#","#","#","#","#","#"],
//             ["#","T","#","#","#","#"],
//             ["#",".",".","B",".","#"],
//             ["#","#","#","#",".","#"],
//             ["#",".",".",".","S","#"],
//             ["#","#","#","#","#","#"]]
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：grid = [["#","#","#","#","#","#"],
//             ["#","T",".",".","#","#"],
//             ["#",".","#","B",".","#"],
//             ["#",".",".",".",".","#"],
//             ["#",".",".",".","S","#"],
//             ["#","#","#","#","#","#"]]
//输出：5
//解释：向下、向左、向左、向上再向上。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 20 
// grid 仅包含字符 '.', '#', 'S' , 'T', 以及 'B'。 
// grid 中 'S', 'B' 和 'T' 各只能出现一个。 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 👍 100 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2023-05-08 01:17:29
 */
public class MinimumMovesToMoveABoxToTheirTargetLocation{
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToMoveABoxToTheirTargetLocation().new Solution();
        System.out.println(solution.minPushBox(new char[][]{{'#','.','.','#','#','#','#','#'},{'#','.','.','T','#','.','.','#'},{'#','.','.','.','#','B','.','#'},{'#','.','.','.','.','.','.','#'},{'#','.','.','.','#','.','S','#'},{'#','.','.','#','#','#','#','#'}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] directions = new int[][] {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
    public int minPushBox(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] start = search(grid, 'B');
        int[] people = search(grid, 'S');
        int[] target = search(grid, 'T');
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(start);
        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] current = deque.pollFirst();
                if (current[0] == target[0] && current[1] == target[1]) {
                    return count;
                }
                visited[current[0]][current[1]] = true;
                for (int j = 0; j < directions.length; j++) {
                    int x = current[0] + directions[j][0];
                    int y = current[1] + directions[j][1];
                    if (x < grid.length && x >= 0 && y < grid[0].length
                            && y >= 0 && grid[x][y] != '#'
                            && !visited[x][y] && search(grid, new int[]{current[0] - directions[j][0], current[1] - directions[j][1]}, people)) {
                        deque.addLast(new int[]{x, y});
                    }
                }
            }
            count++;
        }
        return -1;
    }
    public int[] search(char[][] grid, char c) {
        int[] result = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == c) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public boolean search(char[][] grid, int[] target, int[] start) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(start);
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] current = deque.pollFirst();
                if (current[0] == target[0] && current[1] == target[1]) {
                    return true;
                }
                visited[current[0]][current[1]] = true;
                for (int j = 0; j < directions.length; j++) {
                    int x = current[0] + directions[j][0];
                    int y = current[1] + directions[j][1];
                    if (x < grid.length && x >= 0 && y < grid[0].length && y >= 0
                            && grid[x][y] != '#' && !visited[x][y]) {
                        deque.addLast(new int[]{x, y});
                    }
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}