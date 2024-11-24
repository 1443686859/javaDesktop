/**
给你一个下标从 0 开始的正整数数组 heights ，其中 heights[i] 表示第 i 栋建筑的高度。 

 如果一个人在建筑 i ，且存在 i < j 的建筑 j 满足 heights[i] < heights[j] ，那么这个人可以移动到建筑 j 。 

 给你另外一个数组 queries ，其中 queries[i] = [ai, bi] 。第 i 个查询中，Alice 在建筑 ai ，Bob 在建筑 bi 。
 

 请你能返回一个数组 ans ，其中 ans[i] 是第 i 个查询中，Alice 和 Bob 可以相遇的 最左边的建筑 。如果对于查询 i ，Alice 和 
Bob 不能相遇，令 ans[i] 为 -1 。 

 

 示例 1： 

 
输入：heights = [6,4,8,5,2,7], queries = [[0,1],[0,3],[2,4],[3,4],[2,2]]
输出：[2,5,-1,5,2]
解释：第一个查询中，Alice 和 Bob 可以移动到建筑 2 ，因为 heights[0] < heights[2] 且 heights[1] < 
heights[2] 。
第二个查询中，Alice 和 Bob 可以移动到建筑 5 ，因为 heights[0] < heights[5] 且 heights[3] < heights[
5] 。
第三个查询中，Alice 无法与 Bob 相遇，因为 Alice 不能移动到任何其他建筑。
第四个查询中，Alice 和 Bob 可以移动到建筑 5 ，因为 heights[3] < heights[5] 且 heights[4] < heights[
5] 。
第五个查询中，Alice 和 Bob 已经在同一栋建筑中。
对于 ans[i] != -1 ，ans[i] 是 Alice 和 Bob 可以相遇的建筑中最左边建筑的下标。
对于 ans[i] == -1 ，不存在 Alice 和 Bob 可以相遇的建筑。
 

 示例 2： 

 
输入：heights = [5,3,8,2,6,1,4,6], queries = [[0,7],[3,5],[5,2],[3,0],[1,6]]
输出：[7,6,-1,4,6]
解释：第一个查询中，Alice 可以直接移动到 Bob 的建筑，因为 heights[0] < heights[7] 。
第二个查询中，Alice 和 Bob 可以移动到建筑 6 ，因为 heights[3] < heights[6] 且 heights[5] < heights[
6] 。
第三个查询中，Alice 无法与 Bob 相遇，因为 Bob 不能移动到任何其他建筑。
第四个查询中，Alice 和 Bob 可以移动到建筑 4 ，因为 heights[3] < heights[4] 且 heights[0] < heights[
4] 。
第五个查询中，Alice 可以直接移动到 Bob 的建筑，因为 heights[1] < heights[6] 。
对于 ans[i] != -1 ，ans[i] 是 Alice 和 Bob 可以相遇的建筑中最左边建筑的下标。
对于 ans[i] == -1 ，不存在 Alice 和 Bob 可以相遇的建筑。
 

 

 提示： 

 
 1 <= heights.length <= 5 * 10⁴ 
 1 <= heights[i] <= 10⁹ 
 1 <= queries.length <= 5 * 10⁴ 
 queries[i] = [ai, bi] 
 0 <= ai, bi <= heights.length - 1 
 

 👍 37 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-08-10 14:55:29
 */
public class FindBuildingWhereAliceAndBobCanMeet{
    public static void main(String[] args) {
        Solution solution = new FindBuildingWhereAliceAndBobCanMeet().new Solution();
        System.out.println(solution.leftmostBuildingQueries(new int[]{5,3,8,2,6,1,4,6}, new int[][]					{{0,7},{3,5},{5,2},{3,0},{1,6}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
         int n = queries.length;
         int[] result = new int[n];
         List<int[]> list = new ArrayList<>();
         int index = 0;
         for (int[] query : queries) {
             int a = query[0];
             int b = query[1];
             if (a > b) {
                 int temp = a;
                 a =  b;
                 b = temp;
             }
             if (a == b || heights[b] > heights[a]) {
                 result[index] = b;
             } else {
                 list.add(new int[]{a, b, index});
             }
             index++;
         }
         Collections.sort(list, (a, b)-> b[1] - a[1]);
         int right = heights.length - 1;
         List<int[]> deque = new ArrayList<>();
         int size = 0;
         while (size < list.size()) {
             int[] q = list.get(size);
             int left = q[1];
             while (right > left) {

                 while (!deque.isEmpty() && deque.get(deque.size() - 1)[1] < heights[right]) {
                     deque.remove(deque.size() - 1);
                 }
                 deque.add(new int[]{right, heights[right]});
                 right--;
             }
             result[q[2]] = deque.isEmpty() ? -1 : get(deque, heights[q[0]]);
             size++;
         }
         return result;
    }
    public int get(List<int[]> deque, int target) {
        int left = 0;
        int right = deque.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (deque.get(mid)[1] <= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1 >= deque.size() || left - 1 < 0 ? -1 : deque.get(left - 1)[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}