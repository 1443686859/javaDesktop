//给你一个 rows x cols 大小的矩形披萨和一个整数 k ，矩形包含两种字符： 'A' （表示苹果）和 '.' （表示空白格子）。你需要切披萨 k-1
// 次，得到 k 块披萨并送给别人。 
//
// 切披萨的每一刀，先要选择是向垂直还是水平方向切，再在矩形的边界上选一个切的位置，将披萨一分为二。如果垂直地切披萨，那么需要把左边的部分送给一个人，如果水平
//地切，那么需要把上面的部分送给一个人。在切完最后一刀后，需要把剩下来的一块送给最后一个人。 
//
// 请你返回确保每一块披萨包含 至少 一个苹果的切披萨方案数。由于答案可能是个很大的数字，请你返回它对 10^9 + 7 取余的结果。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：pizza = ["A..","AAA","..."], k = 3
//输出：3 
//解释：上图展示了三种切披萨的方案。注意每一块披萨都至少包含一个苹果。
// 
//
// 示例 2： 
//
// 输入：pizza = ["A..","AA.","..."], k = 3
//输出：1
// 
//
// 示例 3： 
//
// 输入：pizza = ["A..","A..","..."], k = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rows, cols <= 50 
// rows == pizza.length 
// cols == pizza[i].length 
// 1 <= k <= 10 
// pizza 只包含字符 'A' 和 '.' 。 
// 
//
// Related Topics 记忆化搜索 数组 动态规划 矩阵 👍 171 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-08-17 21:19:54
 */
public class NumberOfWaysOfCuttingAPizza{
    public static void main(String[] args) {
        Solution solution = new NumberOfWaysOfCuttingAPizza().new Solution();
        System.out.println(solution.ways(new String[]{"A..","AAA","..."},3));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int mod = (int)1e9 + 7;
    int[][][] meno;
    public int ways(String[] pizza, int k) {
        MatrixSum sum = new MatrixSum(pizza);
        meno = new int[k][pizza.length][pizza[0].length()];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < pizza.length; j++) {
                Arrays.fill(meno[i][j], - 1);
            }
        }
        return dfs(k - 1, 0, 0, sum, pizza.length, pizza[0].length());
    }

    private int dfs(int c, int i , int j, MatrixSum ms, int m, int n) {
        if (meno[c][i][j] != -1) {
            return meno[c][i][j];
        }
        if (c == 0) {
            return ms.query(i,j, m , n) > 0 ? 1 : 0;
        }
        int res = 0;
        for (int j2 = j + 1; j2 < n; j2++) {
            if (ms.query(i, j, m, j2) > 0) {
                res = (res + dfs(c - 1, i, j2, ms, m, n)) % mod;
            }
        }
        for (int i2 = i + 1; i2 < m; i2++) {
            if (ms.query(i, j, i2, n) > 0) {
                res = (res + dfs(c - 1, i2,j , ms, m, n)) % mod;
            }
        }
        meno[c][i][j] = res;
        return res;
    }
    class MatrixSum {
        private final int[][] sum;
        public MatrixSum(String[] matrix) {
            int m = matrix.length;
            int n = matrix[0].length();
            sum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + (matrix[i].charAt(j)  & 1);
                }
            }
        }
        public int query(int r1, int c1, int r2, int c2) {
            return sum[r2][c2] - sum[r2][c1] - sum[r1][c2] + sum[r1][c1];
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}