//给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
// 
//
// 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[1,1],[2,3],[3,2]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：false 
//
// 
//
// 提示： 
// 
//
// 
// points.length == 3 
// points[i].length == 2 
// 0 <= xi, yi <= 100 
// 
// Related Topics 几何 数组 数学 👍 84 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-06-08 21:11:24
 */
public class ValidBoomerang{
    public static void main(String[] args) {
        Solution solution = new ValidBoomerang().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isBoomerang(int[][] points) {
        return (points[2][1] - points[1][1]) * (points[1][0] - points[0][0]) == (points[1][1] - points[0][1]) * (points[2][0]- points[1][0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}