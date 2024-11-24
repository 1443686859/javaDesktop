/**
给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。 

 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从
 0 开始计数）执行异或运算得到。 

 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。 

 

 示例 1： 

 输入：matrix = [[5,2],[1,6]], k = 1
输出：7
解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。 

 示例 2： 

 输入：matrix = [[5,2],[1,6]], k = 2
输出：5
解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。 

 示例 3： 

 输入：matrix = [[5,2],[1,6]], k = 3
输出：4
解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。 

 示例 4： 

 输入：matrix = [[5,2],[1,6]], k = 4
输出：0
解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。 

 

 提示： 

 
 m == matrix.length 
 n == matrix[i].length 
 1 <= m, n <= 1000 
 0 <= matrix[i][j] <= 10⁶ 
 1 <= k <= m * n 
 

 👍 105 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author  YourName
 * @date 2024-05-26 00:12:31
 */
public class FindKthLargestXorCoordinateValue{
    public static void main(String[] args) {
        Solution solution = new FindKthLargestXorCoordinateValue().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] result = new int[n][m];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int[] index = new int[n * m];
        int start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] ^=  matrix[i][j];
                if (i >= 1) {
                    result[i][j] ^= result[i - 1][j];
                }
                if (j >= 1) {
                    result[i][j] ^= result[i][j - 1];
                }
                if (i >= 1 && j >= 1) {
                    result[i][j] ^= result[i - 1][j - 1];
                }
                index[start++] = result[i][j];
            }
        }
        Arrays.sort(index);
        return index[start      - k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}