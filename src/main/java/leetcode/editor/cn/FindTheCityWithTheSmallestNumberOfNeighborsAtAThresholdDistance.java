//有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 
//fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。 
//
// 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。 
//
// 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
//输出：3
//解释：城市分布图如上。
//每个城市阈值距离 distanceThreshold = 4 内的邻居城市分别是：
//城市 0 -> [城市 1, 城市 2] 
//城市 1 -> [城市 0, 城市 2, 城市 3] 
//城市 2 -> [城市 0, 城市 1, 城市 3] 
//城市 3 -> [城市 1, 城市 2] 
//城市 0 和 3 在阈值距离 4 以内都有 2 个邻居城市，但是我们必须返回城市 3，因为它的编号最大。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], 
//distanceThreshold = 2
//输出：0
//解释：城市分布图如上。 
//每个城市阈值距离 distanceThreshold = 2 内的邻居城市分别是：
//城市 0 -> [城市 1] 
//城市 1 -> [城市 0, 城市 4] 
//城市 2 -> [城市 3, 城市 4] 
//城市 3 -> [城市 2, 城市 4]
//城市 4 -> [城市 1, 城市 2, 城市 3] 
//城市 0 在阈值距离 2 以内只有 1 个邻居城市。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 100 
// 1 <= edges.length <= n * (n - 1) / 2 
// edges[i].length == 3 
// 0 <= fromi < toi < n 
// 1 <= weighti, distanceThreshold <= 10^4 
// 所有 (fromi, toi) 都是不同的。 
// 
//
// Related Topics 图 动态规划 最短路 👍 167 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-11-14 21:27:24
 */
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance{
    public static void main(String[] args) {
        Solution solution = new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance().new Solution();
        System.out.println(solution.findTheCity(5, new int[][]{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 2));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], 1000000);
        }
        for (int[] edge : edges) {
           distance[edge[0]][edge[1]] = edge[2];
           distance[edge[1]][edge[0]] = edge[2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int z = 0; z < n; z++) {
                    if (j != z && i != z && i != j && distance[j][z] > distance[j][i] + distance[i][z]) {
                        distance[j][z] = distance[j][i] + distance[i][z];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= min) {
                min = count;
                index = i;
            }
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}