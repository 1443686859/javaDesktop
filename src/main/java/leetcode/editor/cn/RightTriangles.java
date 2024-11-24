/**
给你一个二维 boolean 矩阵 grid 。 

 请你返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。 

 注意： 

 
 如果 grid 中 3 个元素满足：一个元素与另一个元素在 同一行，同时与第三个元素在 同一列 ，那么这 3 个元素称为一个 直角三角形 。这 3 个元素互相
之间不需要相邻。 
 

 

 示例 1： 

 
 
 
 
 0 
 1 
 0 
 
 
 0 
 1 
 1 
 
 
 0 
 1 
 0 
 
 
 
 

 
 
 
 0 
 1 
 0 
 
 
 0 
 1 
 1 
 
 
 0 
 1 
 0 
 
 
 

 
 输入：grid = [[0,1,0],[0,1,1],[0,1,0]] 
 

 输出：2 

 解释： 

 有 2 个直角三角形。 

 示例 2： 

 
 
 
 
 1 
 0 
 0 
 0 
 
 
 0 
 1 
 0 
 1 
 
 
 1 
 0 
 0 
 0 
 
 
 
 

 
 输入：grid = [[1,0,0,0],[0,1,0,1],[1,0,0,0]] 
 

 输出：0 

 解释： 

 没有直角三角形。 

 示例 3： 

 
 
 
 
 1 
 0 
 1 
 
 
 1 
 0 
 0 
 
 
 1 
 0 
 0 
 
 
 
 

 
 
 
 1 
 0 
 1 
 
 
 1 
 0 
 0 
 
 
 1 
 0 
 0 
 
 
 

 
 输入：grid = [[1,0,1],[1,0,0],[1,0,0]] 
 

 输出：2 

 解释： 

 有两个直角三角形。 

 

 提示： 

 
 1 <= grid.length <= 1000 
 1 <= grid[i].length <= 1000 
 0 <= grid[i][j] <= 1 
 

 👍 34 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-08-02 20:31:41
 */
public class RightTriangles{
    public static void main(String[] args) {
        Solution solution = new RightTriangles().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] row = new int[r];
        int[] col = new int[c];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < c; j++) {
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        }
        long ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    ans += Math.max(0, col[j] - 1) * Math.max(0, row[i] - 1);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}