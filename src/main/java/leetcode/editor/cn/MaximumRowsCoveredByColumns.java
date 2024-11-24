//给你一个下标从 0 开始的 m x n 二进制矩阵 mat 和一个整数 cols ，表示你需要选出的列数。 
//
// 如果一行中，所有的 1 都被你选中的列所覆盖，那么我们称这一行 被覆盖 了。 
//
// 请你返回在选择 cols 列的情况下，被覆盖 的行数 最大 为多少。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：mat = [[0,0,0],[1,0,1],[0,1,1],[0,0,1]], cols = 2
//输出：3
//解释：
//如上图所示，覆盖 3 行的一种可行办法是选择第 0 和第 2 列。
//可以看出，不存在大于 3 行被覆盖的方案，所以我们返回 3 。
// 
//
// 示例 2： 
//
// 
//
// 输入：mat = [[1],[0]], cols = 1
//输出：2
//解释：
//选择唯一的一列，两行都被覆盖了，原因是整个矩阵都被覆盖了。
//所以我们返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 12 
// mat[i][j] 要么是 0 要么是 1 。 
// 1 <= cols <= n 
// 
//
// Related Topics 位运算 数组 回溯 枚举 矩阵 👍 28 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-02-09 00:08:53
 */
public class MaximumRowsCoveredByColumns{
    public static void main(String[] args) {
        Solution solution = new MaximumRowsCoveredByColumns().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumRows(int[][] matrix, int numSelect) {
        int[] nums = new int[matrix.length];
        int l = matrix[0].length;
        int numsMax = (1 << l) - 1;
        for (int i = 0; i < matrix.length; i++) {
            int current = 0;
            for (int j = 0; j < matrix[i].length; j ++) {
               current <<= 1;
               current += matrix[i][j];
            }
            nums[i] = current;
        }
        int max = 0;
        int temp = (1 << numSelect) - 1;
        while (temp <= numsMax) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == (nums[i] & temp)) {
                    count++;
                }
            }
            max = Math.max(max, count);
            int lowbit = temp & - temp;
            int next = temp + lowbit;
            temp = ((temp ^ next) / lowbit >> 2)| next;
        }
        return max;
    }

    public boolean check(int current, int k) {
        int count = 0;
       while (current != 0) {
           current &= current - 1;
           count++;
       }
       return count == k;
    }
    public boolean check(int current, int target, int max) {
        for (int i = 0; i <= max; i++) {
            if ((current & (1 << i)) != 0 && (target & (1 << i)) == 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}