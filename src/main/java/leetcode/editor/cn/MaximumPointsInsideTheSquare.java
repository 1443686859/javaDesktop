/**
给你一个二维数组 points 和一个字符串 s ，其中 points[i] 表示第 i 个点的坐标，s[i] 表示第 i 个点的 标签 。 

 如果一个正方形的中心在 (0, 0) ，所有边都平行于坐标轴，且正方形内 不 存在标签相同的两个点，那么我们称这个正方形是 合法 的。 

 请你返回 合法 正方形中可以包含的 最多 点数。 

 注意： 

 
 如果一个点位于正方形的边上或者在边以内，则认为该点位于正方形内。 
 正方形的边长可以为零。 
 

 

 示例 1： 

 

 
 输入：points = [[2,2],[-1,-2],[-4,4],[-3,1],[3,-3]], s = "abdca" 
 

 输出：2 

 解释： 

 边长为 4 的正方形包含两个点 points[0] 和 points[1] 。 

 示例 2： 

 

 
 输入：points = [[1,1],[-2,-2],[-2,2]], s = "abb" 
 

 输出：1 

 解释： 

 边长为 2 的正方形包含 1 个点 points[0] 。 

 示例 3： 

 
 输入：points = [[1,1],[-1,-1],[2,-2]], s = "ccd" 
 

 输出：0 

 解释： 

 任何正方形都无法只包含 points[0] 和 points[1] 中的一个点，所以合法正方形中都不包含任何点。 

 

 提示： 

 
 1 <= s.length, points.length <= 10⁵ 
 points[i].length == 2 
 -10⁹ <= points[i][0], points[i][1] <= 10⁹ 
 s.length == points.length 
 points 中的点坐标互不相同。 
 s 只包含小写英文字母。 
 

 👍 21 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-08-03 11:42:23
 */
public class MaximumPointsInsideTheSquare{
    public static void main(String[] args) {
        Solution solution = new MaximumPointsInsideTheSquare().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int ans = 0;
    public int maxPointsInsideSquare(int[][] points, String s) {
        char[] array = s.toCharArray();
        int left = -1;
        int right = 1_000_000_007;
        while (left  + 1 < right) {
            int mid = (left + right) / 2;
            if (check(mid, points,array)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return ans;
    }
    public boolean check(int size, int[][] points, char[] array) {
        int vis = 0;
        for (int i = 0; i < points.length; i++) {
            if (Math.abs(points[i][0]) <= size && Math.abs(points[i][1]) <= size) {
                int c = array[i] - 'a';
                if ((vis >> c & 1) > 0) {
                    return false;
                }
                vis |= 1 << c;
            }
        }
        ans = Integer.bitCount(vis);
        return true;
    }
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] count = new int[n][11];
        for (int[] p : pick) {
            count[p[0]][p[1]]++;
        }
        int result = 0;
        for (int i =0 ;i < n; i++) {
            for (int j = 0; j <= 10; j++) {
                if (count[i][j] >= i + 1) {
                    result++;
                }
            }
        }
        return result;
    }
    public int minFlips(int[][] grid) {
        int count = 0;
        for (int[] g : grid) {
            int left = 0;
            int right = g.length - 1;
            while (left <= right) {
                if (g[left] != g[right]) {
                    count++;
                }
                left++;
                right--;
            }
        }
        int count1 = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int left = 0;
            int right = grid.length - 1;
            while (left <= right) {
                if (grid[left][i] != grid[right][i]) {
                    count1++;
                }
                left++;
                right--;
            }
        }
        return Math.min(count1, count);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}