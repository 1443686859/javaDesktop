package leetcode.editor.cn;

//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， w
//i 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 
// 👍 366 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkDelayTime{
    public static void main(String[] args) {
        Solution solution = new NetworkDelayTime().new Solution();
        solution.networkDelayTime(new int[][]{
                {2,1,1},{2,3,1},{3,4,1}
        },4, 2);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            final int INF = Integer.MAX_VALUE / 2;
            int[][] g = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(g[i], INF);
            }
            for (int i = 0; i < times.length; i++) {
                g[times[i][0] - 1][times[i][1] -1] = times[i][2];
            }
            int[] dist = new int[n];
            Arrays.fill(dist, INF);
            dist[k - 1] = 0;
            boolean[] used = new boolean[n];
            for (int i = 0; i < n; i++) {
                int start  = -1;
                for (int j = 0; j < n; j++) {
                    if (!used[j] && (start == -1 || dist[j] < dist[start]) ) {
                        start = j;
                    }
                }
                used[start] = true;
                for (int z = 0; z < n; z++) {
                    dist[z] = Math.min(dist[z], dist[start] + g[start][z]);
                }
            }
            int ans = Arrays.stream(dist).max().getAsInt();
            return ans == INF ? -1 : ans;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}