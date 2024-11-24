/**
树可以看成是一个连通且 无环 的 无向 图。 

 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信息记
录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。 

 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的那个。 

 

 示例 1： 

 

 
输入: edges = [[1,2], [1,3], [2,3]]
输出: [2,3]
 

 示例 2： 

 

 
输入: edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
输出: [1,4]
 

 

 提示: 

 
 n == edges.length 
 3 <= n <= 1000 
 edges[i].length == 2 
 1 <= ai < bi <= edges.length 
 ai != bi 
 edges 中无重复元素 
 给定的图是连通的 
 

 👍 658 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-10-27 12:28:47
 */
public class RedundantConnection{
    public static void main(String[] args) {
        Solution solution = new RedundantConnection().new Solution();
        System.out.println(solution.findRedundantConnection(new int[][]{
                {3,4},{1,2},{2,4},{3,5},{2,5}
        }));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] p = new int[edges.length + 1];
        for (int i = 0; i < edges.length + 1; i++) {
            p[i] = i;
        }
        for (int[] e : edges) {
            if (findP(p, e[0]) == findP(p, e[1])) {
                return e;
            }
            merge(p, e[0], e[1]);
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