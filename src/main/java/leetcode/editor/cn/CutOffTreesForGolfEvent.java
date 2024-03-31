//你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个 m x n 的矩阵表示， 在这个矩阵中： 
//
// 
// 0 表示障碍，无法触碰 
// 1 表示地面，可以行走 
// 比 1 大的数 表示有树的单元格，可以行走，数值表示树的高度 
// 
//
// 每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。 
//
// 你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。 
//
// 你将从 (0, 0) 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。 
//
// 可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。 
//
// 
//
// 示例 1： 
//
// 
//输入：forest = [[1,2,3],[0,0,4],[7,6,5]]
//输出：6
//解释：沿着上面的路径，你可以用 6 步，按从最矮到最高的顺序砍掉这些树。 
//
// 示例 2： 
//
// 
//输入：forest = [[1,2,3],[0,0,0],[7,6,5]]
//输出：-1
//解释：由于中间一行被障碍阻塞，无法访问最下面一行中的树。
// 
//
// 示例 3： 
//
// 
//输入：forest = [[2,3,4],[0,0,5],[8,7,6]]
//输出：6
//解释：可以按与示例 1 相同的路径来砍掉所有的树。
//(0,0) 位置的树，可以直接砍去，不用算步数。
// 
//
// 
//
// 提示： 
//
// 
// m == forest.length 
// n == forest[i].length 
// 1 <= m, n <= 50 
// 0 <= forest[i][j] <= 10⁹ 
// 
// Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 👍 173 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en


import java.util.*;

/**
 * @author  YourName
 * @date 2022-05-23 21:49:31
 */
public class CutOffTreesForGolfEvent{
    public static void main(String[] args) {
        Solution solution = new CutOffTreesForGolfEvent().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] grap;
        int n, m;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        m = forest.size();
        n = forest.get(0).size();
        grap = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grap[i][j] = forest.get(i).get(j);
                if (grap[i][j] > 1) {
                    trees.add(new int[]{grap[i][j],i,j});
                }
            }
        }
        Collections.sort(trees, (a, b) -> {return a[0] - b[0];});
        if (grap[0][0] == 0) {
            return -1;
        }
        int startX = 0;
        int startY = 0;
        int ans = 0;
        for (int[] current : trees) {
            int currentX = current[1];
            int currentY = current[2];
            int currentDistance = bfs(startX, startY, currentX, currentY);
            if (currentDistance == -1) {
                return - 1;
            }
            ans += currentDistance;
            startX = currentX;
            startY = currentY;
        }
        return ans;
    }
    int bfs(int startX, int startY, int targetX, int targetY) {
        if (startX == targetX && startY == targetY) {
            return 0;
        }
        boolean[][] vis = new boolean[m][n];
        Deque<int[]> path = new ArrayDeque<>();
        path.add(new int[]{startX, startY});
        vis[startX][startY] = true;
        int currentAns = 0;
        while (!path.isEmpty()) {
            int size = path.size();
            while (size -- > 0) {
                int[] info = path.poll();
                int cx = info[0];
                int cy = info[1];
                for (int[] direction : dirs) {
                    int nx = cx + direction[0];
                    int ny = cy + direction[1];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                      continue;
                    }
                    if (grap[nx][ny] == 0 || vis[nx][ny]) {
                        continue;
                    }
                    if (nx == targetX && ny == targetY) {
                        return currentAns + 1;
                    }
                    path.add(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }
            currentAns++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}