//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
//每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。 
//
// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。 
//
// 请你返回从左上角走到右下角的最小 体力消耗值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
// 
//
// 示例 3： 
// 
// 
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
// 
//
// 
//
// 提示： 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 10⁶ 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 二分查找 矩阵 堆（优先队列） 👍 393 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-12-11 00:07:48
 */
public class PathWithMinimumEffort{
    public static void main(String[] args) {
        Solution solution = new PathWithMinimumEffort().new Solution();
        System.out.println(solution.minimumEffortPath(new int[][]{
        {3}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] directions = new int[][]{{0,1}, {0, -1}, {-1, 0}, {1, 0}};


    public int minimumEffortPath1(int[][] heights) {
        int right = 999999;
        int left = 0;
        while (left <= right) {
            int mid = (right + left) / 2;
            boolean[][] used = new boolean[heights.length][heights[0].length];
            if (dfs(mid, heights, 0, 0, used)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean dfs(int max, int[][] heights, int i, int j, boolean[][] used) {
        if (i == heights.length - 1 && j == heights[0].length - 1) {
            return true;
        }
        used[i][j] = true;
        for (int z = 0; z < 4; z++) {
            int x = i + directions[z][0];
            int y = j + directions[z][1];
            if (x <0 || y < 0 || x >= heights.length || y >= heights[0].length || used[x][y]|| Math.abs(heights[i][j] - heights[x][y]) > max) {
                continue;
            }
            if (dfs(max, heights, x, y, used)) {
                return true;
            }
        }
        return false;
    }
    int[] parent;
    public int minimumEffortPath2(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int current = i * n + j;
                if (i > 0) {
                    edges.add(new int[]{
                            current - n, current, Math.abs(heights[i][j] - heights[i - 1][j])
                    });
                }
                if (j > 0) {
                    edges.add(new int[]{
                            current - 1, current, Math.abs(heights[i][j] - heights[i][j - 1])
                    });
                }
            }
        }
        Collections.sort(edges, (edge1, edge2) ->{
            return edge1[2] - edge2[2];
        });
        parent = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
            if (check(0, n * m - 1)) {
                return edge[2];
            }
        }
        return 0;
    }
    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        int px =find(x);
        int py = find(y);
        parent[px] = py;
    }
    public boolean check(int x , int y) {
        return find(x) == find(y);
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((edge1, edge2) ->{
            return edge1[2] - edge2[2];
        });
        queue.offer(new int[]{0, 0, 0});
        int[] dist = new int[n *m];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        boolean[] used = new boolean[n * m];
        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            int x = edge[0];
            int y = edge[1];
            int current = edge[2];
            int id = x * n + y;
            if (used[id]) {
                continue;
            }
            if (x == m - 1 && y == n - 1) {
                break;
            }
            used[id] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || used[nx * n + ny] || Math.max(current, Math.abs(heights[nx][ny] - heights[x][y])) >= dist[nx * n + ny]) {
                    continue;
                }
                dist[nx * n + ny] =  Math.max(current, Math.abs(heights[nx][ny] - heights[x][y]));
                queue.add(new int[]{nx, ny, dist[nx * n + ny]});
            }
        }
        return dist[n *m - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}