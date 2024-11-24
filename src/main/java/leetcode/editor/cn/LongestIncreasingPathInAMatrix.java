//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
// 
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 数组 动态规划 矩阵 👍 728 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-01-12 21:06:32
 */
public class LongestIncreasingPathInAMatrix{
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
        System.out.println(solution.longestIncreasingPath(new int[][]{{7,8,9},{9,7,6},{7,2,3}}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] preCount = new int[n][m];
        int[][] afterCount = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(preCount[i], 1);
            Arrays.fill(afterCount[i],1);
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            if (matrix[i - 1][0] < matrix[i][0]) {
                preCount[i][0] = preCount[i - 1][0] + 1;
            }
        }
        for (int j = 1; j < m; j++) {
            if (matrix[0][j - 1] < matrix[0][j]) {
                preCount[0][j] = preCount[0][j - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i --) {
            if (matrix[i + 1][m - 1] < matrix[i][m - 1]) {
                afterCount[i][m - 1] = Math.max(afterCount[i + 1][m - 1], preCount[i + 1][m - 1]) + 1;
            }
        }
        for (int j = m - 2; j >= 0; j--) {
            if (matrix[n - 1][j + 1] < matrix[n - 1][j]) {
                afterCount[n - 1][j] = Math.max(afterCount[n - 1][j + 1], preCount[n - 1][j + 1]) + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] > matrix[i - 1][j]) {
                    preCount[i][j] = Math.max(preCount[i][j], preCount[i - 1][j] + 1);
                }
                if (matrix[i][j] > matrix[i][j - 1]) {
                    preCount[i][j] = Math.max(preCount[i][j], preCount[i][j - 1] + 1);
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (matrix[i][j] > matrix[i + 1][j]) {
                    afterCount[i][j] = Math.max(afterCount[i][j], Math.max(afterCount[i + 1][j], preCount[i + 1][j]) + 1);
                }
                if (matrix[i][j] > matrix[i][j +  1]) {
                    afterCount[i][j] = Math.max(afterCount[i][j], Math.max(afterCount[i][j +  1], preCount[i][j +  1]) + 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, Math.max(preCount[i][j], afterCount[i][j]));
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}