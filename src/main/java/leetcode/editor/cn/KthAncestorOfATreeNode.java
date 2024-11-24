//给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0
// 的节点。 
//
// 树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。 
//
// 实现 TreeAncestor 类： 
//
// 
// TreeAncestor（int n， int[] parent） 对树和父数组中的节点数初始化对象。 
// getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节点，返回 -1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：
//["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
//[[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
//
//输出：
//[null,1,0,-1]
//
//解释：
//TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
//
//treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
//treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
//treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节点
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 5 * 10⁴ 
// parent[0] == -1 表示编号为 0 的节点是根节点。 
// 对于所有的 0 < i < n ，0 <= parent[i] < n 总成立 
// 0 <= node < n 
// 至多查询 5 * 10⁴ 次 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二分查找 动态规划 👍 176 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-06-12 20:31:19
 */
public class KthAncestorOfATreeNode{
    public static void main(String[] args) {
//        Solution solution = new KthAncestorOfATreeNode().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class TreeAncestor {
        int[][] pa;
        int l = 16;
    public TreeAncestor(int n, int[] parent) {
        pa = new int[n][l];
        for (int i = 0; i < n; i++) {
            Arrays.fill(pa[i], -1);
        }
        for (int i = 0; i < n; i++) {
            pa[i][0] = parent[i];
        }
        for (int j = 1; j < l; j++) {
            for (int i = 0; i < n; i++) {
                if (pa[i][j - 1] == -1){
                    continue;
                }
                pa[i][j] = pa[pa[i][j - 1]][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 0; i < l; i++) {
            if ((k & (1<< i)) != 0) {
                node = pa[node][i];
                if (node == -1) {
                    break;
                }
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
//leetcode submit region end(Prohibit modification and deletion)

}