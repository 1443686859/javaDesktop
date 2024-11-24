//矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2
//][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。 
//
// 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
//输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,2
//5,68,4],[84,28,14,11,5,50]]
//输出：[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66]
//,[84,28,75,33,55,68]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 100 
// 1 <= mat[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 排序 👍 119 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-04-29 19:20:10
 */
public class SortTheMatrixDiagonally{
    public static void main(String[] args) {
        Solution solution = new SortTheMatrixDiagonally().new Solution();
        System.out.println(solution.diagonalSort(new int[][]			{{11,25,66,1,69,7},{23,55,17,45,15,52},{75,31,36,44,58,8},{22,27,33,25,68,4},{84,28,14,11,5,50}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 1; i < n;i++) {
            int startY = i;
            int max = Math.min(n - i, m);
            for (int j = max - 1; j > 0; j--) {
                for (int z = 0; z < j; z++) {
                    if (mat[startY + z][z] > mat[startY + z + 1][z + 1]) {
                        int temp = mat[startY + z + 1][z + 1];
                        mat[startY + z + 1][z + 1] = mat[startY + z][z];
                        mat[startY + z][z] = temp;
                    }
                }
            }
        }
        for (int j = 0; j < m; j++) {
            int startX = j;
            int max = Math.min(n, m - j);
            for (int i = max - 1; i > 0; i--) {
                for (int z = 0; z < i; z++) {
                    if (mat[z][startX + z] > mat[z + 1][startX + z + 1]) {
                        int temp = mat[z + 1][startX + z + 1];
                        mat[z + 1][startX + z + 1] = mat[z][startX + z];
                        mat[z][startX + z] = temp;
                    }
                }
            }
        }
        return mat;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}