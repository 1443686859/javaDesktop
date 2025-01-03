//给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。 
//
// 学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。请你计算并返回该考场可以容纳的同时参加考试
//且无法作弊的 最大 学生人数。 
//
// 学生必须坐在状况良好的座位上。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：seats = [["#",".","#","#",".","#"],
//              [".","#","#","#","#","."],
//              ["#",".","#","#",".","#"]]
//输出：4
//解释：教师可以让 4 个学生坐在可用的座位上，这样他们就无法在考试中作弊。 
// 
//
// 示例 2： 
//
// 
//输入：seats = [[".","#"],
//              ["#","#"],
//              ["#","."],
//              ["#","#"],
//              [".","#"]]
//输出：3
//解释：让所有学生坐在可用的座位上。
// 
//
// 示例 3： 
//
// 
//输入：seats = [["#",".",".",".","#"],
//              [".","#",".","#","."],
//              [".",".","#",".","."],
//              [".","#",".","#","."],
//              ["#",".",".",".","#"]]
//输出：10
//解释：让学生坐在第 1、3 和 5 列的可用座位上。
// 
//
// 
//
// 提示： 
//
// 
// seats 只包含字符 '.' 和'#' 
// m == seats.length 
// n == seats[i].length 
// 1 <= m <= 8 
// 1 <= n <= 8 
// 
//
// Related Topics 位运算 数组 动态规划 状态压缩 矩阵 👍 224 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-12-26 21:59:32
 */
public class MaximumStudentsTakingExam{
    public static void main(String[] args) {
        Solution solution = new MaximumStudentsTakingExam().new Solution();
        System.out.println(solution.maxStudents(new char[][]{{'#','.','.','.','#'},{'.','#','.','#','.'},{'.','.','#','.','.'},{'.','#','.','#','.'},{'#','.','.','.','#'}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '.') {
                    a[i] |= 1 << j;
                }
            }
        }
        int[][] memo = new int[m][1 << n];
        for (int[] o : memo) {
            Arrays.fill(o,  -1);
        }
        return dfs(memo, a, m - 1, a[m - 1]);
    }
    public int dfs(int[][] memo, int[] a, int i , int j) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (i == 0) {
            if (j == 0) {
                return 0;
            }
            // 剔除最低位1，如果之前有1则剔除 lowbit *3 = (lowbit << 1 ) | lowbit
            int lowbit = j & - j;
            return dfs(memo, a, i, j & ~(lowbit * 3)) + 1;
        }
        int current = dfs(memo, a, i - 1, a[i - 1]);
        for (int s = j; s > 0; s = (s - 1) & j) {
            // 枚举j的子集
            if ((s & (s << 1)) == 0) {
                // 判断是否有相邻的1
                int next = a[i - 1] & ~(s << 1 | s >> 1);
                // 对上一排可用座位进行当前枚举子集相邻取反
                current = Math.max(current, dfs(memo, a, i - 1, next) + Integer.bitCount(s));
            }
        }
        memo[i][j] = current;
        return current;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}