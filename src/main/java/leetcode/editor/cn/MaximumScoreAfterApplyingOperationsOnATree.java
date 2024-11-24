//有一棵 n 个节点的无向树，节点编号为 0 到 n - 1 ，根节点编号为 0 。给你一个长度为 n - 1 的二维整数数组 edges 表示这棵树，其中 
//edges[i] = [ai, bi] 表示树中节点 ai 和 bi 有一条边。 
//
// 同时给你一个长度为 n 下标从 0 开始的整数数组 values ，其中 values[i] 表示第 i 个节点的值。 
//
// 一开始你的分数为 0 ，每次操作中，你将执行： 
//
// 
// 选择节点 i 。 
// 将 values[i] 加入你的分数。 
// 将 values[i] 变为 0 。 
// 
//
// 如果从根节点出发，到任意叶子节点经过的路径上的节点值之和都不等于 0 ，那么我们称这棵树是 健康的 。 
//
// 你可以对这棵树执行任意次操作，但要求执行完所有操作以后树是 健康的 ，请你返回你可以获得的 最大分数 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：edges = [[0,1],[0,2],[0,3],[2,4],[4,5]], values = [5,2,5,2,1,1]
//输出：11
//解释：我们可以选择节点 1 ，2 ，3 ，4 和 5 。根节点的值是非 0 的。所以从根出发到任意叶子节点路径上节点值之和都不为 0 。所以树是健康的。你的
//得分之和为 values[1] + values[2] + values[3] + values[4] + values[5] = 11 。
//11 是你对树执行任意次操作以后可以获得的最大得分之和。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values = [20,10,9,7,4,3,5]
//输出：40
//解释：我们选择节点 0 ，2 ，3 和 4 。
//- 从 0 到 4 的节点值之和为 10 。
//- 从 0 到 3 的节点值之和为 10 。
//- 从 0 到 5 的节点值之和为 3 。
//- 从 0 到 6 的节点值之和为 5 。
//所以树是健康的。你的得分之和为 values[0] + values[2] + values[3] + values[4] = 40 。
//40 是你对树执行任意次操作以后可以获得的最大得分之和。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 2 * 10⁴ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// values.length == n 
// 1 <= values[i] <= 10⁹ 
// 输入保证 edges 构成一棵合法的树。 
// 
//
// 👍 16 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-11-06 21:59:51
 */
public class MaximumScoreAfterApplyingOperationsOnATree{
    public static void main(String[] args) {
        Solution solution = new MaximumScoreAfterApplyingOperationsOnATree().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        List<Integer>[] grap = new List[n];
        Arrays.setAll(grap, e -> new ArrayList<>());
        grap[0].add(-1);
        for (int[] edge : edges) {
            grap[edge[0]].add(edge[1]);
            grap[edge[1]].add(edge[0]);
        }
        long sum = 0;
        for (int i : values) {
            sum += i;
        }
        return sum - dfs(grap, values, -1, 0);
    }
    public long dfs(List<Integer>[] grap, int[] value, int pa, int current) {
        if (grap[current].size() == 1) {
            return value[current];
        }
        long son = 0;
        for (int i : grap[current]) {
            if (i != pa) {
                son += dfs(grap, value, current, i);
            }
        }
        return Math.min(son, value[current]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}