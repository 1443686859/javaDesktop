//给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直区域 的宽度。 
//
// 垂直区域 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直区域 为宽度最大的一个垂直区域。 
//
// 请注意，垂直区域 边上 的点 不在 区域内。 
//
// 
//
// 示例 1： 
// 
// 
//输入：points = [[8,7],[9,9],[7,4],[9,7]]
//输出：1
//解释：红色区域和蓝色区域都是最优区域。
// 
//
// 示例 2： 
//
// 
//输入：points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 2 <= n <= 10⁵ 
// points[i].length == 2 
// 0 <= xi, yi <= 10⁹ 
// 
//
// Related Topics 数组 排序 👍 57 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-03-30 20:51:04
 */
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints{
    public static void main(String[] args) {
        Solution solution = new WidestVerticalAreaBetweenTwoPointsContainingNoPoints().new Solution();
        System.out.println(solution.maxWidthOfVerticalArea1(new int[][]{
                {3,1},{9,0},{1,0},{1,4},{5,3},{8,8}
        }));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return a[0] - b[0];
        });
        int max = 0;
        for (int i = 1; i < points.length; i++) {
            max = Math.max(max, points[i][0] - points[i - 1][0]);
        }
        return max;
    }
    public int maxWidthOfVerticalArea1(int[][] points) {
        int n = points.length;
        int[] nums = new int[n];
        final int inf = 1 << 30;
        int max = -inf;
        int min = inf;
        int i = 0;
        for (int[] point : points) {
            nums[i ++] = point[0];
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
        }
        // 单个桶平均跨度
        int bucketSize = Math.max(1, (max - min)/ (n - 1));
        // 桶数量
        int size = (max - min) / bucketSize + 1;
        int[][] bucket = new int[size][2];
        for (int[] b : bucket) {
            b[0] = inf;
            b[1] = -inf;
        }
        for (int v : nums) {
           int index = (v - min) / bucketSize;
           bucket[index][0] = Math.min(bucket[index][0], v);
           bucket[index][1] = Math.max(bucket[index][1], v);
        }
        int result = 0;
        int pre = inf;
        for (int[] b : bucket) {
            if (b[0] > b[1]) {
                continue;
            }
            result = Math.max(result, b[0] - pre);
            pre = b[1];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}