//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。 
//
// 请返回 封闭岛屿 的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,
//0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 209 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-06-18 10:17:18
 */
public class NumberOfClosedIslands{
    public static void main(String[] args) {
        Solution solution = new NumberOfClosedIslands().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int closedIsland(int[][] grid) {
//        int startIndex = 2;
//        int[] index = new int[grid.lenght * grid[0].lenght];
//        for (int i = 0; i < grid.lenght; i++) {
//            for (int j = 0; j < grid[i].lenght; j++) {
//                index[i * j] = i * j;
//            }
//        }
//    }
//    public void merge(int[] index, int i, int j) {
//        if (index[i] != index[j]) {
//
//        }
//    }
//    pubcli
}
//leetcode submit region end(Prohibit modification and deletion)

}