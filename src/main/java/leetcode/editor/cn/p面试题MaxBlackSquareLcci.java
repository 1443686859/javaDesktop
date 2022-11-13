package leetcode.editor.cn;
//给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。 
//
// 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 
//最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。 
//
// 示例 1: 
//
// 输入:
//[
//   [1,0,1],
//   [0,0,1],
//   [0,0,1]
//]
//输出: [1,0,2]
//解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
// 
//
// 示例 2: 
//
// 输入:
//[
//   [0,1,1],
//   [1,0,1],
//   [1,1,0]
//]
//输出: [0,0,1]
// 
//
// 提示： 
//
// 
// matrix.length == matrix[0].length <= 200 
// 
// Related Topics 数组 动态规划 矩阵 👍 34 👎 0

public class p面试题MaxBlackSquareLcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSquare(new int[][]{   {1,0,1},{0,0,1},
                {0,0,1}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    public int[] findSquare(int[][] matrix) {
        int  n = matrix.length;
        int[][] rMatrix = new int[n][n];
        int[][] lMatrix = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    lMatrix[i][j] = 1;
                    if (i < n - 1) {
                        lMatrix[i][j] += lMatrix[i + 1][j];
                    }
                    rMatrix[i][j] = 1;
                    if (j < n - 1) {
                        rMatrix[i][j] += rMatrix[i][j + 1];
                    }
                }
            }
        }
        int r = 0;
        int c = 0;
        int size = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int maxSize = Math.min(rMatrix[i][j], lMatrix[i][j]);
                if (maxSize == 0) {
                    continue;
                }
                for (int k = maxSize; k >= 0; k--) {
                    if (i + k - 1 <0 || i + k - 1 >= n || j + k -1 < 0 || j + k - 1 >= n) {
                        continue;
                    }
                    if (rMatrix[i + k - 1][j] >= k && lMatrix[i][j + k - 1] >= k && k > size) {
                        size = k;
                        r = i;
                        c = j;
                        break;
                    }
                }

            }
        }

        if (size == 0) {
            return new int[0];
        }
        return new int[]{r, c, size};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}