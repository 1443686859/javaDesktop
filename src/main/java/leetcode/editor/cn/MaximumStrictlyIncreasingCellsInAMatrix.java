/**
给你一个下标从 1 开始、大小为 m x n 的整数矩阵 mat，你可以选择任一单元格作为 起始单元格 。 

 从起始单元格出发，你可以移动到 同一行或同一列 中的任何其他单元格，但前提是目标单元格的值 严格大于 当前单元格的值。 

 你可以多次重复这一过程，从一个单元格移动到另一个单元格，直到无法再进行任何移动。 

 请你找出从某个单元开始访问矩阵所能访问的 单元格的最大数量 。 

 返回一个表示可访问单元格最大数量的整数。 

 

 示例 1： 

 

 输入：mat = [[3,1],[3,4]]
输出：2
解释：上图展示了从第 1 行、第 2 列的单元格开始，可以访问 2 个单元格。可以证明，无论从哪个单元格开始，最多只能访问 2 个单元格，因此答案是 2 。 
 

 示例 2： 

 

 输入：mat = [[1,1],[1,1]]
输出：1
解释：由于目标单元格必须严格大于当前单元格，在本示例中只能访问 1 个单元格。 
 

 示例 3： 

 

 输入：mat = [[3,1,6],[-9,5,7]]
输出：4
解释：上图展示了从第 2 行、第 1 列的单元格开始，可以访问 4 个单元格。可以证明，无论从哪个单元格开始，最多只能访问 4 个单元格，因此答案是 4 。  

 

 

 提示： 

 
 m == mat.length 
 n == mat[i].length 
 1 <= m, n <= 10⁵ 
 1 <= m * n <= 10⁵ 
 -10⁵ <= mat[i][j] <= 10⁵ 
 

 👍 76 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-06-19 20:32:10
 */
public class MaximumStrictlyIncreasingCellsInAMatrix{
    public static void main(String[] args) {
        Solution solution = new MaximumStrictlyIncreasingCellsInAMatrix().new Solution();
        System.out.println(solution.maxIncreasingCells(new int[][]{
                {3,1,6}, {-9,5,7}
        }));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maxIncreasingCells(int[][] mat) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                map.computeIfAbsent(mat[i][j], e -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        int ans = 1;
        for (List<int[]> list : map.values()) {
            int[] f = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                int[] current = list.get(i);
                f[i] = Math.max(1 + row[current[0]], 1 + col[current[1]]);
                ans = Math.max(ans, f[i]);
            }
            for (int i = 0; i < f.length; i++) {
                int[] current = list.get(i);
                row[current[0]] = Math.max(row[current[0]], f[i]);
                col[current[1]] = Math.max(col[current[1]], f[i]);
            }
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}