//如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ： 
//
// 
// 矩阵对角线上的所有元素都 不是 0 
// 矩阵中所有其他元素都是 0 
// 
//
// 给你一个大小为 n x n 的二维整数数组 grid ，表示一个正方形矩阵。如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false 
//。 
//
// 
//
// 示例 1： 
// 输入：grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
//输出：true
//解释：矩阵如上图所示。
//X 矩阵应该满足：绿色元素（对角线上）都不是 0 ，红色元素都是 0 。
//因此，grid 是一个 X 矩阵。
// 
//
// 示例 2： 
// 输入：grid = [[5,7,0],[0,3,1],[0,5,0]]
//输出：false
//解释：矩阵如上图所示。
//X 矩阵应该满足：绿色元素（对角线上）都不是 0 ，红色元素都是 0 。
//因此，grid 不是一个 X 矩阵。
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 3 <= n <= 100 
// 0 <= grid[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 矩阵 👍 38 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-01-31 21:04:02
 */
public class CheckIfMatrixIsXMatrix{
    public static void main(String[] args) {
        Solution solution = new CheckIfMatrixIsXMatrix().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkXMatrix(int[][] grid) {
         int n = grid.length;
         for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                if (i == j || (i + j) == n- 1) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
             }
         }
         return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}