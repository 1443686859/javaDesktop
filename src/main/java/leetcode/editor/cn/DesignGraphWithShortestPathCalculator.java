//给你一个有 n 个节点的 有向带权 图，节点编号为 0 到 n - 1 。图中的初始边用数组 edges 表示，其中 edges[i] = [fromi, 
//toi, edgeCosti] 表示从 fromi 到 toi 有一条代价为 edgeCosti 的边。 
//
// 请你实现一个 Graph 类： 
//
// 
// Graph(int n, int[][] edges) 初始化图有 n 个节点，并输入初始边。 
// addEdge(int[] edge) 向边集中添加一条边，其中 edge = [from, to, edgeCost] 。数据保证添加这条边之前对应的两
//个节点之间没有有向边。 
// int shortestPath(int node1, int node2) 返回从节点 node1 到 node2 的路径 最小 代价。如果路径不存在，
//返回 -1 。一条路径的代价是路径中所有边代价之和。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：
//["Graph", "shortestPath", "shortestPath", "addEdge", "shortestPath"]
//[[4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]], [3, 2], [0, 3], [[1, 3, 4]
//], [0, 3]]
//输出：
//[null, 6, -1, null, 6]
//
//解释：
//Graph g = new Graph(4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]);
//g.shortestPath(3, 2); // 返回 6 。从 3 到 2 的最短路径如第一幅图所示：3 -> 0 -> 1 -> 2 ，总代价为 3 +
// 2 + 1 = 6 。
//g.shortestPath(0, 3); // 返回 -1 。没有从 0 到 3 的路径。
//g.addEdge([1, 3, 4]); // 添加一条节点 1 到节点 3 的边，得到第二幅图。
//g.shortestPath(0, 3); // 返回 6 。从 0 到 3 的最短路径为 0 -> 1 -> 3 ，总代价为 2 + 4 = 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 0 <= edges.length <= n * (n - 1) 
// edges[i].length == edge.length == 3 
// 0 <= fromi, toi, from, to, node1, node2 <= n - 1 
// 1 <= edgeCosti, edgeCost <= 10⁶ 
// 图中任何时候都不会有重边和自环。 
// 调用 addEdge 至多 100 次。 
// 调用 shortestPath 至多 100 次。 
// 
//
// Related Topics 图 设计 最短路 堆（优先队列） 👍 48 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author  YourName
 * @date 2024-03-26 22:17:33
 */
public class DesignGraphWithShortestPathCalculator{
    public static void main(String[] args) {
//        Solution solution = new DesignGraphWithShortestPathCalculator().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Graph1 {
    List<int[]>[] grap;

    public Graph1(int n, int[][] edges) {
        grap = new ArrayList[n];
        Arrays.setAll(grap, e-> new ArrayList<>());
        for (int[] e : edges) {
            addEdge(e);
        }
    }
    
    public void addEdge(int[] edge) {
        grap[edge[0]].add(new int[]{edge[1], edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        int[] result = new int[grap.length];
        Arrays.fill(result,  Integer.MAX_VALUE / 3);
        result[node1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[]{0, node1});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int next = current[1];
            if (next == node2) {
                return current[0];
            }
            if (result[next] < current[0]) {
                continue;
            }
            for (int[] e : grap[next]) {
                int n = e[0];
                int c = e[1];
                if (current[0] + c < result[n]) {
                    result[n] = current[0] + c;
                    pq.offer(new int[]{result[n], n});
                }
            }
        }
        return - 1;
    }
}
    class Graph {
        int[][] g;

        public Graph(int n, int[][] edges) {
            g = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(g[i], Integer.MAX_VALUE / 3);
                g[i][i] = 0;
            }
            for (int[] e : edges) {
                g[e[0]][e[1]] = e[2];
            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if (g[i][k] == Integer.MAX_VALUE / 3) {
                        continue;
                    }
                    for (int j = 0; j < n; j++) {
                        g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                    }
                }
            }
        }

        public void addEdge(int[] edge) {
            if (g[edge[0]][edge[1]] < edge[2]) {
                return;
            }
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g.length; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][edge[0]] + edge[2] + g[edge[1]][j]);
                }
            }
        }

        public int shortestPath(int node1, int node2) {
           return g[node1][node2] >= Integer.MAX_VALUE / 3 ?  - 1 : g[node1][node2];
        }
    }
/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}