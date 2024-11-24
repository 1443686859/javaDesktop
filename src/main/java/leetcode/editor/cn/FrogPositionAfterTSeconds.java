//给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下： 
//
// 
// 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。 
// 青蛙无法跳回已经访问过的顶点。 
// 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。 
// 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。 
// 
//
// 无向树的边用数组 edges 描述，其中 edges[i] = [ai, bi] 意味着存在一条直接连通 ai 和 bi 两个顶点的边。 
//
// 返回青蛙在 t 秒后位于目标顶点 target 上的概率。与实际答案相差不超过 10⁻⁵ 的结果将被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
//输出：0.16666666666666666 
//解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，因此青蛙
//在 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。 
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
//输出：0.3333333333333333
//解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，有 1/3 = 0.3333333333333333 的概率能够 1 秒 后跳到顶点 7 。 
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ai, bi <= n 
// 1 <= t <= 50 
// 1 <= target <= n 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 图 👍 93 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-05-24 20:06:47
 */
public class FrogPositionAfterTSeconds{
    public static void main(String[] args) {
        Solution solution = new FrogPositionAfterTSeconds().new Solution();
        System.out.println(solution.frogPosition(7, new int[][]{
                {1,2},{1,3},{1,7},{2,4},{2,6},{3,5}
        }, 2,4));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        boolean[] visited;
        List<Integer>[] list;
        int ta;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        ta = target;
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        visited[1] = true;
        return dfs(1, 1, t, - 1);
    }
    public double dfs(int current, int result, int t, int pre) {
        if (t == 0 && current == ta) {
            return 1d / result;
        }
        if (t == -1) {
            return 0;
        }
        int count = 0;
        double ans = 0d;
        for (int i = 0; i < list[current].size(); i++) {
            if (!visited[list[current].get(i)]) {
                visited[list[current].get(i)] = true;
                int size = list[current].contains(pre) ? list[current].size() - 1 : list[current].size();
                ans = dfs(list[current].get(i), result * size, t - 1, current);
                if (ans != 0) {
                   return ans;
                }
                visited[list[current].get(i)] = false;
                count++;
            }
        }
        if (count == 0) {
            ans = dfs(current, result, t - 1, current);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}