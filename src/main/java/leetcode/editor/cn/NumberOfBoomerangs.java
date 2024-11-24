//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 所有点都 互不相同 
// 
//
// Related Topics 数组 哈希表 数学 👍 302 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2024-01-08 20:51:20
 */
public class NumberOfBoomerangs{
    public static void main(String[] args) {
        Solution solution = new NumberOfBoomerangs().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = get(points[i], points[j]);
            }
        }
        int count = 0;
        for (int i = 0 ;i < n; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int di : d[i]) {
                countMap.put(di, countMap.getOrDefault(di, 0) + 1);
            }
            for (int di : countMap.values()) {
                if (di > 1) {
                    count += di * (di - 1);
                }
            }
        }
        return count;
    }
    public int get(int[] pre, int[] after) {
        int x = Math.abs(pre[0] - after[0]);
        int y = Math.abs(pre[1] - after[1]);
        return x * x + y * y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}