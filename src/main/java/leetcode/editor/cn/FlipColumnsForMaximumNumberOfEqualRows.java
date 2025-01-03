//给定 m x n 矩阵 matrix 。 
//
// 你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。） 
//
// 返回 经过一些翻转后，行与行之间所有值都相等的最大行数 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[0,1],[1,1]]
//输出：1
//解释：不进行翻转，有 1 行所有值都相等。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[0,1],[1,0]]
//输出：2
//解释：翻转第一列的值之后，这两行都由相等的值组成。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
//输出：2
//解释：翻转前两列的值之后，后两行由相等的值组成。 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] == 0 或 1 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 126 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-05-15 21:08:03
 */
public class FlipColumnsForMaximumNumberOfEqualRows{
    public static void main(String[] args) {
        Solution solution = new FlipColumnsForMaximumNumberOfEqualRows().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            int base = matrix[i][0];
            char[] result = new char[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                result[j] = (char)(matrix[i][j] ^ base);
            }
            String current = new String(result);
            map.put(current, map.getOrDefault(current, 0) + 1);
            max = Math.max(max, map.get(current));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}