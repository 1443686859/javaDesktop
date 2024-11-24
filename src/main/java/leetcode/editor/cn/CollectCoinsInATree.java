//给你一个 n 个节点的无向无根树，节点编号从 0 到 n - 1 。给你整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[
//i] = [ai, bi] 表示树中节点 ai 和 bi 之间有一条边。再给你一个长度为 n 的数组 coins ，其中 coins[i] 可能为 0 也可能为
// 1 ，1 表示节点 i 处有一个金币。 
//
// 一开始，你需要选择树中任意一个节点出发。你可以执行下述操作任意次： 
//
// 
// 收集距离当前节点距离为 2 以内的所有金币，或者 
// 移动到树中一个相邻节点。 
// 
//
// 你需要收集树中所有的金币，并且回到出发节点，请你返回最少经过的边数。 
//
// 如果你多次经过一条边，每一次经过都会给答案加一。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：coins = [1,0,0,0,0,1], edges = [[0,1],[1,2],[2,3],[3,4],[4,5]]
//输出：2
//解释：从节点 2 出发，收集节点 0 处的金币，移动到节点 3 ，收集节点 5 处的金币，然后移动回节点 2 。
// 
//
// 示例 2： 
//
// 
//
// 输入：coins = [0,0,0,1,1,0,0,1], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[5,6],[5
//,7]]
//输出：2
//解释：从节点 0 出发，收集节点 4 和 3 处的金币，移动到节点 2 处，收集节点 7 处的金币，移动回节点 0 。
// 
//
// 
//
// 提示： 
//
// 
// n == coins.length 
// 1 <= n <= 3 * 10⁴ 
// 0 <= coins[i] <= 1 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// edges 表示一棵合法的树。 
// 
//
// Related Topics 树 图 拓扑排序 数组 👍 122 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en



import java.util.*;

/**
 * @author  YourName
 * @date 2023-09-21 21:50:51
 */
public class CollectCoinsInATree{
    public static void main(String[] args) {
        Solution solution = new CollectCoinsInATree().new Solution();
        System.out.println(solution.collectTheCoins(new int[]{1,0,0,0,0,1}, new int[][]{
                {0,1},{1,2},{2,3},{3,4},{4,5}
        }));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        int[] d = new int[n];
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
            d[e[0]]++;
            d[e[1]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (d[i] == 1 && coins[i] == 0) {
                q.add(i);
            }
        }
        int result = n - 1;
        while (!q.isEmpty()) {
            result--;
            int current = q.pollFirst();
            for (int i : g[current]) {
                if (--d[i] == 1 && coins[i] == 0) {
                    q.add(i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (d[i] == 1 && coins[i] == 1) {
                q.add(i);
            }
        }
        result -= q.size();
        for (int i : q) {
            for (int j : g[i]) {
                if (--d[j] == 1) {
                    result --;
                }
            }
        }
        return Math.max(2 * result, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}