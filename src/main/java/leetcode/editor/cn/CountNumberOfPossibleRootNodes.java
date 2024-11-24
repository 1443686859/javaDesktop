//Alice 有一棵 n 个节点的树，节点编号为 0 到 n - 1 。树用一个长度为 n - 1 的二维整数数组 edges 表示，其中 edges[i] 
//= [ai, bi] ，表示树中节点 ai 和 bi 之间有一条边。 
//
// Alice 想要 Bob 找到这棵树的根。她允许 Bob 对这棵树进行若干次 猜测 。每一次猜测，Bob 做如下事情： 
//
// 
// 选择两个 不相等 的整数 u 和 v ，且树中必须存在边 [u, v] 。 
// Bob 猜测树中 u 是 v 的 父节点 。 
// 
//
// Bob 的猜测用二维整数数组 guesses 表示，其中 guesses[j] = [uj, vj] 表示 Bob 猜 uj 是 vj 的父节点。 
//
// Alice 非常懒，她不想逐个回答 Bob 的猜测，只告诉 Bob 这些猜测里面 至少 有 k 个猜测的结果为 true 。 
//
// 给你二维整数数组 edges ，Bob 的所有猜测和整数 k ，请你返回可能成为树根的 节点数目 。如果没有这样的树，则返回 0。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：edges = [[0,1],[1,2],[1,3],[4,2]], guesses = [[1,3],[0,1],[1,0],[2,4]], k =
// 3
//输出：3
//解释：
//根为节点 0 ，正确的猜测为 [1,3], [0,1], [2,4]
//根为节点 1 ，正确的猜测为 [1,3], [1,0], [2,4]
//根为节点 2 ，正确的猜测为 [1,3], [1,0], [2,4]
//根为节点 3 ，正确的猜测为 [1,0], [2,4]
//根为节点 4 ，正确的猜测为 [1,3], [1,0]
//节点 0 ，1 或 2 为根时，可以得到 3 个正确的猜测。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：edges = [[0,1],[1,2],[2,3],[3,4]], guesses = [[1,0],[3,4],[2,1],[3,2]], k =
// 1
//输出：5
//解释：
//根为节点 0 ，正确的猜测为 [3,4]
//根为节点 1 ，正确的猜测为 [1,0], [3,4]
//根为节点 2 ，正确的猜测为 [1,0], [2,1], [3,4]
//根为节点 3 ，正确的猜测为 [1,0], [2,1], [3,2], [3,4]
//根为节点 4 ，正确的猜测为 [1,0], [2,1], [3,2]
//任何节点为根，都至少有 1 个正确的猜测。
// 
//
// 
//
// 提示： 
//
// 
// edges.length == n - 1 
// 2 <= n <= 10⁵ 
// 1 <= guesses.length <= 10⁵ 
// 0 <= ai, bi, uj, vj <= n - 1 
// ai != bi 
// uj != vj 
// edges 表示一棵有效的树。 
// guesses[j] 是树中的一条边。 
// guesses 是唯一的。 
// 0 <= k <= guesses.length 
// 
//
// Related Topics 树 深度优先搜索 哈希表 动态规划 👍 86 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-02-29 23:54:25
 */
public class CountNumberOfPossibleRootNodes{
    public static void main(String[] args) {
        Solution solution = new CountNumberOfPossibleRootNodes().new Solution();
        System.out.println(solution.rootCount(new int[][]{{0,1},{1,2},{1,3},{4,2}}, new int[][]{{1,3},{0,1},{1,0},{2,4}},
                3
                ));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<Integer>[] list;
        int k;
        Set<Long> set;
        int ans;
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n = edges.length + 1;
        list = new List[n];
        set = new HashSet<>();
        this.k = k;
        ans = 0;
        Arrays.setAll(list, e -> new ArrayList<>());
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        for (int[] guess : guesses) {
            set.add((((long) guess[0]) << 20) | guess[1]);
        }
        int count = dfs(0, -1);
        reroot(0, -1, count);
        return ans;
    }
    public int dfs(int start, int pa) {
        int count = 0;
        if (set.contains(((long) pa << 20| start))) {
            count++;
        }
        for (int i : list[start]) {
            if (i != pa) {
                count += dfs(i, start);
            }
        }
        return count;
    }
    public void reroot(int start, int pa, int count) {
        if (count >= k) {
            ans++;
        }
        for (int i : list[start]) {
            if (i != pa) {
                int c = count;
                if (set.contains((long) start << 20 | i)) c--; // 原来是对的，现在错了
                if (set.contains((long) i << 20 | start)) c++;
                reroot(i, start, c);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}