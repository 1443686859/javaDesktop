//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
// Related Topics 数组 矩阵 模拟 👍 357 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-06-14 22:33:52
 */
public class DiagonalTraverse{
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
        System.out.println(solution.findDiagonalOrder(new int[][]{{7},{9},{6}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
         int m = mat.length;
         int n = mat[0].length;
         int[] result = new int[m * n];
         int direction = -1;
         int end = m + n - 1;
         int startIndex = 0;
         for (int i = 0; i < end; i++) {
             int currentX = 0;
             int currentY = 0;
             if (i >= n) {
                 currentX = i - n + 1;
                 currentY = n - 1
                 ;
             } else {
                 currentX = 0;
                 currentY = i;
             }
             int tempLength = 0;
             if (i >= n) {
                 tempLength = Math.min(n ,m - currentX);
             } else {
                 tempLength = Math.min(m, i + 1);
             }
             int[] temp = new int[tempLength];
             int currentStart = 0;
             while (currentX < m && currentY >= 0) {
                 if (direction < 0) {
                     temp[tempLength - 1 - currentStart] = mat[currentX][currentY];
                 } else {
                     temp[currentStart] = mat[currentX][currentY];
                 }
                 currentX ++;
                 currentY--;
                 currentStart++;
             }
             System.arraycopy(temp, 0, result, startIndex, tempLength);
             startIndex += tempLength;
             direction *= -1;
         }
         return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}