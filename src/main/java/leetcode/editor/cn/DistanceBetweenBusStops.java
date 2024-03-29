//环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号
//为 (i + 1) % n 的车站之间的距离。 
//
// 环线上的公交车都可以按顺时针和逆时针的方向行驶。 
//
// 返回乘客从出发点 start 到目的地 destination 之间的最短距离。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：distance = [1,2,3,4], start = 0, destination = 1
//输出：1
//解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：distance = [1,2,3,4], start = 0, destination = 2
//输出：3
//解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：distance = [1,2,3,4], start = 0, destination = 3
//输出：4
//解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^4 
// distance.length == n 
// 0 <= start, destination < n 
// 0 <= distance[i] <= 10^4 
// 
//
// Related Topics 数组 👍 79 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-07-24 16:37:19
 */
public class DistanceBetweenBusStops{
    public static void main(String[] args) {
        Solution solution = new DistanceBetweenBusStops().new Solution();
        System.out.println(solution.distanceBetweenBusStops(new int[]{7,10,1,12,11,14,5,0}, 7,2 ));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int end = Math.max(start, destination);
        int begin = Math.min(start, destination);
        int[] sum = new int[n + 1];
        for (int i = 1; i < n; i++) {
           sum[i] = sum[i - 1] + distance[i - 1];
        }

        int total = sum[n - 1];
        int result = sum[end] - sum[begin];
        return Math.min(result, total + distance[n - 1] - result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}