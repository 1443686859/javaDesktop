//这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。 
//
// 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。 
//
// 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[1,0],[0,1]]
//输出：0
//解释：没有一台服务器能与其他服务器进行通信。 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[1,0],[1,1]]
//输出：3
//解释：所有这些服务器都至少可以与一台别的服务器进行通信。
// 
//
// 示例 3： 
//
// 
//
// 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
//输出：4
//解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m <= 250 
// 1 <= n <= 250 
// grid[i][j] == 0 or 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 计数 矩阵 👍 113 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-08-24 23:34:55
 */
public class CountServersThatCommunicate{
    public static void main(String[] args) {
        Solution solution = new CountServersThatCommunicate().new Solution();
        System.out.println(solution.countServers(new int[][]{{0,0,0,0},{1,1,1,1},{0,0,0,1},{0,0,1,1},{0,0,0,1}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] d = new int[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i * m + j] = i * m + j;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int z = i - 1; z >= 0; z--) {
                        if (grid[z][j] == 1)
                        merge(d, i * m + j,  z * m +j);
                    }
                    for (int z = j - 1; z >= 0; z--) {
                        if (grid[i][z] == 1)
                        merge(d, i * m + j,  i * m + z);
                    }
                }
            }
        }
        int result = 0;
        int[] count = new int[n * m];
        for (int i = 0; i < n * m; i++) {
            int target = findP(d, i);
            count[target]++;
        }

        for (int i : count) {
            if (i > 1){
                result += i;
            }
        }
        return result;
    }
    public void merge(int[] d, int index, int current) {
        int p1 = findP(d, index);
        int p2 = findP(d, current);
        if (p1 != p2) {
            d[p1] = d[p2];
        }
    }
    public int findP(int[] d, int index) {
        if (index == d[index]) {
            return index;
        } else {
            d[index] = findP(d, d[index]);
        }
        return d[index];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}