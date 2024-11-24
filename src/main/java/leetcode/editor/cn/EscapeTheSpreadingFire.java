//给你一个下标从 0 开始大小为 m x n 的二维整数数组 grid ，它表示一个网格图。每个格子为下面 3 个值之一： 
//
// 
// 0 表示草地。 
// 1 表示着火的格子。 
// 2 表示一座墙，你跟火都不能通过这个格子。 
// 
//
// 一开始你在最左上角的格子 (0, 0) ，你想要到达最右下角的安全屋格子 (m - 1, n - 1) 。每一分钟，你可以移动到 相邻 的草地格子。每次你
//移动 之后 ，着火的格子会扩散到所有不是墙的 相邻 格子。 
//
// 请你返回你在初始位置可以停留的 最多 分钟数，且停留完这段时间后你还能安全到达安全屋。如果无法实现，请你返回 -1 。如果不管你在初始位置停留多久，你 总
//是 能到达安全屋，请你返回 10⁹ 。 
//
// 注意，如果你到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。 
//
// 如果两个格子有共同边，那么它们为 相邻 格子。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0
//,0,0,0,0,0,0]]
//输出：3
//解释：上图展示了你在初始位置停留 3 分钟后的情形。
//你仍然可以安全到达安全屋。
//停留超过 3 分钟会让你无法安全到达安全屋。 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
//输出：-1
//解释：上图展示了你马上开始朝安全屋移动的情形。
//火会蔓延到你可以移动的所有格子，所以无法安全到达安全屋。
//所以返回 -1 。
// 
//
// 示例 3： 
//
// 
//
// 输入：grid = [[0,0,0],[2,2,0],[1,2,0]]
//输出：1000000000
//解释：上图展示了初始网格图。
//注意，由于火被墙围了起来，所以无论如何你都能安全到达安全屋。
//所以返回 10⁹ 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 2 <= m, n <= 300 
// 4 <= m * n <= 2 * 10⁴ 
// grid[i][j] 是 0 ，1 或者 2 。 
// grid[0][0] == grid[m - 1][n - 1] == 0 
// 
//
// Related Topics 广度优先搜索 数组 二分查找 矩阵 👍 113 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author  YourName
 * @date 2023-11-09 20:34:21
 */
public class EscapeTheSpreadingFire{
    public static void main(String[] args) {
        Solution solution = new EscapeTheSpreadingFire().new Solution();
        System.out.println(solution.maximumMinutes(new int[][]
                {{0,0,2,2,1,1,0,2,1,1,2,2,0,2,2,1,2,0,1,2,2,0,1,2,2,1,2,2},
                        {2,2,2,1,1,2,2,1,2,0,1,1,1,2,2,1,1,0,2,2,2,0,1,0,1,2,2,2},{0,0,1,1,0,1,2,0,1,1,1,1,0,2,0,2,0,2,1,1,0,2,1,2,2,2,1,2},{2,2,0,0,0,0,1,0,1,0,2,0,1,0,2,0,0,1,2,1,0,1,1,1,2,0,2,0},{2,2,1,1,1,1,1,0,0,0,0,2,0,1,1,1,1,2,0,2,1,1,2,0,2,0,2,0},{0,1,0,1,2,2,2,0,2,0,2,2,1,2,0,0,1,0,2,0,2,0,1,2,2,0,2,0},{1,0,2,2,2,0,2,0,2,0,2,0,1,0,2,2,0,2,1,1,1,0,1,0,1,1,0,0},{0,1,2,0,1,0,1,0,2,1,2,0,1,1,1,1,0,1,1,0,0,2,0,1,0,1,0,2},{2,1,1,0,1,1,2,2,1,2,2,1,0,1,0,0,0,2,1,0,2,2,1,2,1,2,0,1},{1,1,2,0,2,2,1,2,0,2,1,1,0,0,0,2,2,2,2,1,2,2,0,2,1,1,2,0},{2,1,2,2,0,0,1,0,1,2,1,0,1,0,2,0,0,1,1,0,2,0,2,0,1,2,2,0},{1,0,1,1,0,0,0,0,0,1,0,2,0,2,1,2,1,1,0,1,0,0,2,1,2,1,0,2},{2,0,1,0,2,0,1,0,2,0,2,1,2,0,2,2,2,1,0,2,1,0,1,2,1,0,1,1},{0,2,2,1,0,2,1,0,1,2,2,1,2,2,1,2,0,1,2,2,0,2,1,0,2,1,0,0},{0,2,2,2,1,2,1,0,0,2,2,0,1,0,2,1,0,0,2,1,1,1,2,1,2,1,0,1},{2,2,2,1,1,1,1,0,2,2,2,1,0,0,2,2,0,0,1,1,0,0,2,1,2,1,2,2},{2,1,2,1,1,1,0,2,1,0,1,1,2,1,0,0,1,1,2,1,2,2,1,2,0,2,0,0}}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] direction = new int[][]{
            {1,0}, {0,1},{-1,0},{0,-1}
    };
    int MAX = 1000000000;
    public int maximumMinutes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 这里我用开区间二分（其它写法也可以）
        int left = -1, right = m * n + 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(grid,new int[2], mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left < m * n ? left : 1_000_000_000;

    }
    public int getMin(int[] start, int[][] grid) {
        int min = 0;
        Deque<int[]> current =  new ArrayDeque<>();
        current.add(start);
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        while (!current.isEmpty()) {
            int size = current.size();
            for (int i = 0; i < size; i++) {
                int[] now = current.pollFirst();
                visited[now[0]][now[1]] = true;
                if (grid[now[0]][now[1]] == 1) {
                    return min;
                }
                for (int[] d : direction) {
                    int x = now[0] + d[0];
                    int y = now[1] + d[1];
                    if (x >= grid.length || x < 0 || y >= grid[0].length || y <0 || grid[x][y] == 2 || visited[x][y]) {
                        continue;
                    }
                    current.addLast(new int[]{x, y});
                }
            }
            min++;
        }
        return MAX;
    }

    public boolean check(int[][] grid, int[] start, int time) {
        Deque<int[]> current =  new ArrayDeque<>();

        int m = grid.length;
        int n = grid[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0 ;i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    current.add(new int[]{i, j});
                }
                temp[i][j] = grid[i][j];
            }
        }
        for (int i = 0; i < time; i++) {
            extracted(current, temp);
        }
        boolean[][] vis = new boolean[m][n];
        Deque<int[]> p = new ArrayDeque<>();
        p.add(start);
        while (!p.isEmpty()) {

            int size = p.size();
            for (int j = 0; j < size; j++) {
                int[] now = p.pollFirst();
                if (temp[now[0]][now[1]] == 1) {
                    continue;
                }
                for (int[] d : direction) {
                    int x = now[0] + d[0];
                    int y = now[1] + d[1];
                    if (x >= temp.length || x < 0 || y >= temp[0].length || y < 0 || temp[x][y] != 0 || vis[x][y]) {
                        continue;
                    }
                    if (x == m - 1 && y == n -1) {
                        return true;
                    }

                    vis[x][y] = true; // 避免反复访问同一个位置
                    p.addLast(new int[]{x, y});
                }
            }
            extracted(current, temp);
        }

        return false;
    }

    private void extracted(Deque<int[]> current, int[][] temp) {
        int size = current.size();
        for (int j = 0; j < size; j++) {
            int[] now = current.pollFirst();
            for (int[] d : direction) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];
                if (x >= temp.length || x < 0 || y >= temp[0].length || y <0 || temp[x][y] != 0) {
                    continue;
                }
                temp[x][y] = 1;
                current.addLast(new int[]{x, y});
            }
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}