/**
一个国家有 n 个城市，城市编号为 0 到 n - 1 ，题目保证 所有城市 都由双向道路 连接在一起 。道路由二维整数数组 edges 表示，其中 
edges[i] = [xi, yi, timei] 表示城市 xi 和 yi 之间有一条双向道路，耗费时间为 timei 分钟。两个城市之间可能会有多条耗费时间不同的道
路，但是不会有道路两头连接着同一座城市。 

 每次经过一个城市时，你需要付通行费。通行费用一个长度为 n 且下标从 0 开始的整数数组 passingFees 表示，其中 passingFees[j] 是
你经过城市 j 需要支付的费用。 

 一开始，你在城市 0 ，你想要在 maxTime 分钟以内 （包含 maxTime 分钟）到达城市 n - 1 。旅行的 费用 为你经过的所有城市 通行费之和
 （包括 起点和终点城市的通行费）。 

 给你 maxTime，edges 和 passingFees ，请你返回完成旅行的 最小费用 ，如果无法在 maxTime 分钟以内完成旅行，请你返回 -1 
。 

 

 示例 1： 

 

 
输入：maxTime = 30, edges = [[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]],
 passingFees = [5,1,2,20,20,3]
输出：11
解释：最优路径为 0 -> 1 -> 2 -> 5 ，总共需要耗费 30 分钟，需要支付 11 的通行费。
 

 示例 2： 

 

 
输入：maxTime = 29, edges = [[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]],
 passingFees = [5,1,2,20,20,3]
输出：48
解释：最优路径为 0 -> 3 -> 4 -> 5 ，总共需要耗费 26 分钟，需要支付 48 的通行费。
你不能选择路径 0 -> 1 -> 2 -> 5 ，因为这条路径耗费的时间太长。
 

 示例 3： 

 
输入：maxTime = 25, edges = [[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]],
 passingFees = [5,1,2,20,20,3]
输出：-1
解释：无法在 25 分钟以内从城市 0 到达城市 5 。
 

 

 提示： 

 
 1 <= maxTime <= 1000 
 n == passingFees.length 
 2 <= n <= 1000 
 n - 1 <= edges.length <= 1000 
 0 <= xi, yi <= n - 1 
 1 <= timei <= 1000 
 1 <= passingFees[j] <= 1000 
 图中两个节点之间可能有多条路径。 
 图中不含有自环。 
 

 👍 74 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-10-03 11:03:35
 */
public class MinimumCostToReachDestinationInTime{
    public static void main(String[] args) {
        Solution solution = new MinimumCostToReachDestinationInTime().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] p;
        int[][] map;
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        int[][] dp = new int[maxTime + 1][n];
        for (int i = 0; i <= maxTime; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = passingFees[0];
        for (int i = 1; i <= maxTime; i++) {
            for (int[] e : edges) {
                int l = e[0], r = e[1];
                int cost = e[2];
                if (i >= cost) {
                    dp[i][l] = Math.min(dp[i - cost][r] + passingFees[l], dp[i][l]);
                    dp[i][r] = Math.min(dp[i][r], dp[i - cost][l] + passingFees[r]);
                }
            }
        }
        int result = Integer.MAX_VALUE / 2;
        for (int i = 1; i <= maxTime; i++) {
            result = Math.min(result, dp[i][passingFees.length - 1]);
        }
        return result == Integer.MAX_VALUE / 2 ? -1 : result;
//        map = new int[n][maxTime + 1];
//        p = passingFees;
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(map[i], -1);
//        }
//        int result = dfs(graph, maxTime, map.length - 1);
//        return result >= Integer.MAX_VALUE / 2 ? -1 : result;
    }
    public int dfs(List<int[]>[] grap, int resTime, int current) {
        if (resTime < 0) {
            return Integer.MAX_VALUE / 2;
        }
        if (current == 0) {
            return p[current];
        }
        if (map[current][resTime] != -1) {
            return map[current][resTime];
        }
        int min = Integer.MAX_VALUE / 2;
        for (int[] g : grap[current]) {
            if (g[0] != current) {
                min = Math.min(min ,dfs(grap, resTime - g[1], g[0]));
            }
        }
        map[current][resTime] = min + p[current];
        return min + p[current];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}