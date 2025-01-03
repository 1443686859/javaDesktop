//你在一个城市里，城市由 n 个路口组成，路口编号为 0 到 n - 1 ，某些路口之间有 双向 道路。输入保证你可以从任意路口出发到达其他任意路口，且任意两
//个路口之间最多有一条路。 
//
// 给你一个整数 n 和二维整数数组 roads ，其中 roads[i] = [ui, vi, timei] 表示在路口 ui 和 vi 之间有一条需要花费
// timei 时间才能通过的道路。你想知道花费 最少时间 从路口 0 出发到达路口 n - 1 的方案数。 
//
// 请返回花费 最少时间 到达目的地的 路径数目 。由于答案可能很大，将结果对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
// 输入：n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2
//,5,1],[0,4,5],[4,6,2]]
//输出：4
//解释：从路口 0 出发到路口 6 花费的最少时间是 7 分钟。
//四条花费 7 分钟的路径分别为：
//- 0 ➝ 6
//- 0 ➝ 4 ➝ 6
//- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
//- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
// 
//
// 示例 2： 
//
// 输入：n = 2, roads = [[1,0,10]]
//输出：1
//解释：只有一条从路口 0 到路口 1 的路，花费 10 分钟。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n - 1 <= roads.length <= n * (n - 1) / 2 
// roads[i].length == 3 
// 0 <= ui, vi <= n - 1 
// 1 <= timei <= 10⁹ 
// ui != vi 
// 任意两个路口之间至多有一条路。 
// 从任意路口出发，你能够到达其他任意路口。 
// 
//
// Related Topics 图 拓扑排序 动态规划 最短路 👍 118 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-03-05 20:09:53
 */
public class NumberOfWaysToArriveAtDestination{
    public static void main(String[] args) {
        Solution solution = new NumberOfWaysToArriveAtDestination().new Solution();
        System.out.println(solution.countPaths(7, new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPaths(int n, int[][] roads) {
        long[][] g = new long[n][n];
        for (long[] grap : g) {
            Arrays.fill(grap, Long.MAX_VALUE / 2);
        }
        for (int[] r : roads) {
            g[r[0]][r[1]]= r[2];
            g[r[1]][r[0]] = r[2];
        }
        long[] cost = new long[n];
        Arrays.fill(cost, Long.MAX_VALUE / 2);
        cost[0] = 0;
        int[] result = new int[n];
        result[0] = 1;
        boolean[] visited = new boolean[n];
        while (true) {
            int min = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && (min == - 1 || cost[min] > cost[i])) {
                    min = i;
                }
            }
            if (min == n - 1) {
                return result[min];
            }
            visited[min] = true;
            for (int i = 0; i < n; i++) {
                long newCost = cost[min] + g[min][i];
                if (newCost < cost[i]) {
                    cost[i] = newCost;
                    result[i] = result[min];
                } else if (newCost == cost[i]) {
                    result[i] = (result[i] + result[min]) % 1_000_000_007;
                }
            }
        }
    } 


}
//leetcode submit region end(Prohibit modification and deletion)

}