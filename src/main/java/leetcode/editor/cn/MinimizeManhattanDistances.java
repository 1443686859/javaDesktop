/**
给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。 

 两点之间的距离定义为它们的曼哈顿距离。 

 请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。 

 

 示例 1： 

 
输入：points = [[3,10],[5,15],[10,2],[4,4]]
输出：12
解释：移除每个点后的最大距离如下所示：
- 移除第 0 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间，为 |5 - 10| + |15 - 2| = 18 。
- 移除第 1 个点后，最大距离在点 (3, 10) 和 (10, 2) 之间，为 |3 - 10| + |10 - 2| = 15 。
- 移除第 2 个点后，最大距离在点 (5, 15) 和 (4, 4) 之间，为 |5 - 4| + |15 - 4| = 12 。
- 移除第 3 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间的，为 |5 - 10| + |15 - 2| = 18 。
在恰好移除一个点后，任意两点之间的最大距离可能的最小值是 12 。
 

 示例 2： 

 
输入：points = [[1,1],[1,1],[1,1]]
输出：0
解释：移除任一点后，任意两点之间的最大距离都是 0 。
 

 

 提示： 

 
 3 <= points.length <= 10⁵ 
 points[i].length == 2 
 1 <= points[i][0], points[i][1] <= 10⁸ 
 

 👍 40 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-07-09 20:39:36
 */
public class MinimizeManhattanDistances{
    public static void main(String[] args) {
        Solution solution = new MinimizeManhattanDistances().new Solution();
        System.out.println(solution.minimumDistance(new int[][]{{3,10},{5,15},{10,2},{4,4}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDistance(int[][] points) {
        int[][] p1 = new int[points.length][2];
        int[][] p2 = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            p1[i][0] = points[i][0] + points[i][1];
            p2[i][0] = points[i][0] - points[i][1];
            p1[i][1] = i;
            p2[i][1] = i;
        }
        Arrays.sort(p1, (a, b) -> a[0] - b[0]);
        Arrays.sort(p2, (a, b) -> a[0] - b[0]);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int max = p1[p1.length - 1][1] == i ? p1[p1.length - 2][0] : p1[p1.length - 1][0];
            int min = p1[0][1] == i ? p1[1][0] : p1[0][0];
            int temp1 = max - min;
            max = p2[p2.length - 1][1] == i ? p2[p2.length - 2][0] : p2[p2.length - 1][0];
            min = p2[0][1] == i ? p2[1][0] : p2[0][0];
            temp1 = Math.max(max - min, temp1);
            result = Math.min(result, temp1);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}