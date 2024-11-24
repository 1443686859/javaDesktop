/**
给你一个 m x n 的二进制矩阵 grid 。 

 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。 

 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。 

 请你返回 最少 翻转次数，使得矩阵中 所有 行和列都是 回文的 ，且矩阵中 1 的数目可以被 4 整除 。 

 

 示例 1： 

 
 输入：grid = [[1,0,0],[0,1,0],[0,0,1]] 
 

 输出：3 

 解释： 

 

 示例 2： 

 
 输入：grid = [[0,1],[0,1],[0,0]] 
 

 输出：2 

 解释： 

 

 示例 3： 

 
 输入：grid = [[1],[1]] 
 

 输出：2 

 解释： 

 

 

 提示： 

 
 m == grid.length 
 n == grid[i].length 
 1 <= m * n <= 2 * 10⁵ 
 0 <= grid[i][j] <= 1 
 

 👍 35 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-11-16 19:47:45
 */
public class MinimumNumberOfFlipsToMakeBinaryGridPalindromicIi{
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfFlipsToMakeBinaryGridPalindromicIi().new Solution();
        System.out.println(solution.minFlips(new int[][]{
                {1,0,0},
                {0,1,0},
                {0,0,1}
        }));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFlips(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length/ 2; i++) {
            for (int j = 0; j < grid[i].length / 2; j++) {
                int ni = grid.length - 1 - i;
                int nj = grid[i].length - 1 - j;
                int temp = grid[i][j] + grid[ni][nj] + grid[i][nj] + grid[ni][j];
                count += Math.min(temp , 4 - temp);
            }
        }
        int n = grid.length;
        int m = grid[0].length;
        int temp = 0;
        if ((n & 1) != 0 && (m & 1) != 0) {
            count += grid[n / 2][m / 2];
        }
        int sum = 0;
        if ((n & 1) != 0) {
            int i = n / 2;
            for (int j = 0; j < grid[i].length / 2; j++) {
                if (grid[i][j] == grid[i][grid[0].length - 1 - j]) {
                    temp += 2 * grid[i][j];
                } else {
                    sum++;
                }
            }
        }
        if ((m & 1) != 0) {
            int j = m / 2;
            for (int i = 0; i < grid.length / 2; i++) {
                if (grid[i][j] == grid[grid.length - 1 - i][j]) {
                    temp += 2 * grid[i][j];
                } else {
                    sum++;
                }
            }
        }
        if (sum > 0) {
            count += sum;
        } else {
            count += temp % 4;
        }
        return count ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}