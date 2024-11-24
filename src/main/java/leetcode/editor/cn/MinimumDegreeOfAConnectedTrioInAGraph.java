//给你一个无向图，整数 n 表示图中节点的数目，edges 数组表示图中的边，其中 edges[i] = [ui, vi] ，表示 ui 和 vi 之间有一条
//无向边。 
//
// 一个 连通三元组 指的是 三个 节点组成的集合且这三个点之间 两两 有边。 
//
// 连通三元组的度数 是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。 
//
// 请你返回所有连通三元组中度数的 最小值 ，如果图中没有连通三元组，那么返回 -1 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]
//输出：3
//解释：只有一个三元组 [1,2,3] 。构成度数的边在上图中已被加粗。
// 
//
// 示例 2： 
// 
// 
//输入：n = 7, edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]
//输出：0
//解释：有 3 个三元组：
//1) [1,4,3]，度数为 0 。
//2) [2,5,6]，度数为 2 。
//3) [5,6,7]，度数为 2 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 400 
// edges[i].length == 2 
// 1 <= edges.length <= n * (n-1) / 2 
// 1 <= ui, vi <= n 
// ui != vi 
// 图中没有重复的边。 
// 
//
// Related Topics 图 👍 75 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-08-31 18:28:33
 */
public class MinimumDegreeOfAConnectedTrioInAGraph{
    public static void main(String[] args) {
        Solution solution = new MinimumDegreeOfAConnectedTrioInAGraph().new Solution();
        System.out.println(solution.minTrioDegree(7, new int[][]{{1,3},{4,1},{4,3},{2,5},{5,6},{6,7},{7,5},{2,6}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] c = new boolean[n][n];
        int[] d = new int[n];
        for (int[] e : edges) {
            c[e[0] - 1][e[1] - 1] = true;
            c[e[1] - 1][e[0] - 1] = true;
            d[e[0] - 1]++;
            d[e[1] - 1]++;
        }

        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> d[a] - d[b]);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (d[index[i]] * 3 - 6 >= min) {
                break;
            }
            for (int j = i + 1; j < n; j++) {
                if (!c[index[i]][index[j]]) {
                    continue;
                }
                if (d[index[i]] + 2 * d[index[j]]>= min) {
                    break;
                }
                for (int z = j + 1; z < n; z++) {
                    if (d[index[i]] + d[index[j]] + d[index[z]] >= min) {
                         break;
                    }
                    if (!c[index[i]][index[z]] || !c[index[j]][index[z]]) {
                        continue;
                    }
                    min = d[index[i]] + d[index[j]] + d[index[z]] ;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min - 6;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}