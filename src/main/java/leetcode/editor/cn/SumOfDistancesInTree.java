//给定一个无向、连通的树。树中有 n 个标记为 0...n-1 的节点以及 n-1 条边 。 
//
// 给定整数 n 和数组 edges ， edges[i] = [ai, bi]表示树中的节点 ai 和 bi 之间有一条边。 
//
// 返回长度为 n 的数组 answer ，其中 answer[i] 是树中第 i 个节点与所有其他节点之间的距离之和。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
//输出: [8,12,6,10,10,10]
//解释: 树如图所示。
//我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5) 
//也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
// 
//
// 示例 2: 
// 
// 
//输入: n = 1, edges = []
//输出: [0]
// 
//
// 示例 3: 
// 
// 
//输入: n = 2, edges = [[1,0]]
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 3 * 10⁴ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// 给定的输入保证为有效的树 
// 
//
// Related Topics 树 深度优先搜索 图 动态规划 👍 436 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-07-16 15:47:26
 */
public class SumOfDistancesInTree{
    public static void main(String[] args) {
        Solution solution = new SumOfDistancesInTree().new Solution();
        System.out.println(solution.sumOfDistancesInTree(4, new int[][]{
                {2,0},{3,1},{2,1}
        }));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] count;
    int[] result;

    int distance;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        result = new int[n];
        List<Integer>[] map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        count = new int[n];
        Arrays.fill(count, - 1);
        getCount(map, - 1, 0, 0);
        reroot(map, 0, - 1);
        return result;
    }
    public void getCount(List<Integer>[] map, int parent, int current, int depth) {
        result[0] += depth;
        int currentResult = 1;
        for (int i : map[current]) {
            if (parent != i) {
                getCount(map, current, i, depth + 1);
                currentResult += count[i];
            }
        }
        count[current] = currentResult;
    }
    public void reroot(List<Integer>[] map,int x, int parent) {
        for (int i : map[x]) {
            if (i != parent) {
                result[i] = result[x] + map.length - 2 * count[i];
                reroot(map, i, x);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}