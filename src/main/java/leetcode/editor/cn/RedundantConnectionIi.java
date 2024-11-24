/**
在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节点没
有父节点。 

 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。附加的边包含在 1 到 n 中的两个不同顶点间，这条附加
的边不属于树中已存在的边。 

 结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 
vi 的一个父节点。 

 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。 

 

 示例 1： 
 
 
输入：edges = [[1,2],[1,3],[2,3]]
输出：[2,3]
 

 示例 2： 
 
 
输入：edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
输出：[4,1]
 

 

 提示： 

 
 n == edges.length 
 3 <= n <= 1000 
 edges[i].length == 2 
 1 <= ui, vi <= n 
 

 👍 448 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-10-28 22:27:16
 */
public class RedundantConnectionIi{
    public static void main(String[] args) {
        Solution solution = new RedundantConnectionIi().new Solution();
        System.out.println(solution.findRedundantDirectedConnection(new int[][]{{2,1},{3,1},{4,2},{1,4}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] p = new int[edges.length + 1];
        List<Integer>[] in = new List[edges.length + 1];
        List<Integer>[] out = new List[edges.length + 1];
        Arrays.setAll(in, e -> new ArrayList<>());
        Arrays.setAll(out, e -> new ArrayList<>());
        for (int i = 0; i < edges.length + 1; i++) {
            p[i] = i;
        }
        List<Integer> target = new ArrayList<>();
        int index = -1;
        for (int[] e : edges) {
            in[e[1]].add(e[0]);
            if (in[e[1]].size() > 1) {
                target = in[e[1]];
                index = e[1];
            }
            out[e[0]].add(e[1]);
        }
        if (!target.isEmpty()) {
                for (int j = 0; j < edges.length + 1; j++) {
                    p[j] = j;
                }
                for (int[] e : edges) {
                    if (e[1] != index || e[0] != target.get(target.size() - 1)) {
                        merge(p, e[0], e[1]);
                    }
                }
                Set<Integer> count = new HashSet<>();
                for (int j = 1; j < p.length; j++) {
                    count.add(findP(p, j));
                }
                if (count.size() == 1) {
                    return new int[]{target.get(target.size() - 1), index};
                } else {
                    return new int[]{target.get(0), index};
                }

        } else {
            for (int[] e : edges) {
                if (findP(p, e[0]) == findP(p, e[1])) {
                    return e;
                }
                merge(p, e[0], e[1]);
            }
        }

        return null;
    }
    public int findP(int[] p, int i) {
        if (p[i] != i) {
            p[i] = findP(p, p[i]);
        }
        return p[i];
    }
    public void merge(int[] p, int i, int j) {
        int pJ = findP(p, j);
        p[pJ] = findP(p, i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}