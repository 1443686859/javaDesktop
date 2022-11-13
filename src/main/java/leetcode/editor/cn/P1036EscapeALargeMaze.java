package leetcode.editor.cn;
//在一个 10⁶ x 10⁶ 的网格中，每个网格上方格的坐标为 (x, y) 。 
//
// 现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。数组 blocked 是封锁的方格列表
//，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。 
//
// 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。同时，不允许走出网格。 
//
// 只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
//输出：false
//解释：
//从源方格无法到达目标方格，因为我们无法在网格中移动。
//无法向北或者向东移动是因为方格禁止通行。
//无法向南或者向西移动是因为不能走出网格。 
//
// 示例 2： 
//
// 
//输入：blocked = [], source = [0,0], target = [999999,999999]
//输出：true
//解释：
//因为没有方格被封锁，所以一定可以到达目标方格。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= blocked.length <= 200 
// blocked[i].length == 2 
// 0 <= xi, yi < 10⁶ 
// source.length == target.length == 2 
// 0 <= sx, sy, tx, ty < 10⁶ 
// source != target 
// 题目数据保证 source 和 target 不在封锁列表内 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 哈希表 👍 142 👎 0

import java.util.*;

public class P1036EscapeALargeMaze {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isEscapePossible(new int[][] {}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        static final int BOUNDARY = 100000;
        static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
            if (blocked.length < 2) {
                return true;
            }
            TreeSet<Integer> rows = new TreeSet<>();
            TreeSet<Integer> cols = new TreeSet<>();
            for (int[] pos : blocked) {
                rows.add(pos[0]);
                cols.add(pos[1]);
            }
            rows.add(source[0]);
            rows.add(target[0]);
            cols.add(source[1]);
            cols.add(target[1]);
            Map<Integer, Integer> rowsMap = new HashMap<>();
            Map<Integer, Integer> colsMap = new HashMap<>();
            int firstRow = rows.first();
            int rId = (firstRow == 0 ? 0 : 1);
            rowsMap.put(firstRow, rId);
            int preRow = firstRow;
            for (int row : rows) {
                if (row == firstRow) {
                    continue;
                }
                rId += (row == preRow + 1 ? 1 : 2);
                rowsMap.put(row, rId);
                preRow = row;
            }
            if (preRow != BOUNDARY - 1) {
                rId++;
            }
            int firstCol = cols.first();
            int cId = firstCol == 0 ? 0 : 1;
            colsMap.put(firstCol, cId);
            int preCol = firstCol;
            for (int col : cols) {
                if (col == firstCol) {
                    continue;
                }
                cId += (col == preCol + 1 ? 1 : 2);
                colsMap.put(col, cId);
                preCol = col;
            }
            if (preCol != BOUNDARY - 1) {
                cId++;
            }
            int[][] grid = new int[rId + 1][cId + 1];
            for (int[] pos : blocked) {
                int x = pos[0];
                int y = pos[1];
                grid[rowsMap.get(x)][colsMap.get(y)] = 1;
            }
            int sx = rowsMap.get(source[0]);
            int sy = colsMap.get(source[1]);
            int tx = rowsMap.get(target[0]);
            int ty = colsMap.get(target[1]);
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{sx, sy});
            grid[sx][sy] = 1;
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                int x = arr[0];
                int y = arr[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dirs[d][0];
                    int ny = y + dirs[d][1];
                    if (nx >= 0 && ny >= 0 && nx <= rId && ny <= cId && grid[nx][ny] != 1) {
                        if (nx == tx && ny == ty) {
                            return true;
                        }
                        queue.offer(new int[]{nx, ny});
                        grid[nx][ny] = 1;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}