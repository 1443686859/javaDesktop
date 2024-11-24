/**
给你一个 m x n 的二进制矩阵 grid 。 

 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。 

 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。 

 请你返回 最少 翻转次数，使得矩阵 要么 所有行是 回文的 ，要么所有列是 回文的 。 

 

 示例 1： 

 
 输入：grid = [[1,0,0],[0,0,0],[0,0,1]] 
 

 输出：2 

 解释： 

 

 将高亮的格子翻转，得到所有行都是回文的。 

 示例 2： 

 
 输入：grid = [[0,1],[0,1],[0,0]] 
 

 输出：1 

 解释： 

 

 将高亮的格子翻转，得到所有列都是回文的。 

 示例 3： 

 
 输入：grid = [[1],[0]] 
 

 输出：0 

 解释： 

 所有行已经是回文的。 

 

 提示： 

 
 m == grid.length 
 n == grid[i].length 
 1 <= m * n <= 2 * 10⁵ 
 0 <= grid[i][j] <= 1 
 

 👍 30 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-11-15 23:16:49
 */
public class MinimumNumberOfFlipsToMakeBinaryGridPalindromicI{
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfFlipsToMakeBinaryGridPalindromicI().new Solution();
        System.out.println(solution.minFlips(new int[][]{
                {0,1},{0,1},{0,0}
        }));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFlips(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length / 2; j++) {
                if (grid[i][j] != grid[i][grid[0].length - j - 1]) {
                    count++;
                }
            }
        }
        int min = 0;
        for (int i = 0; i < grid.length / 2; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != grid[grid.length - i - 1][j]) {
                    min++;
                }
            }
        }
        return Math.min(min, count);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}