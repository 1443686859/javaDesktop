//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。 
//
// 示例 3： 
//
// 
//输入：intervals = [], newInterval = [5,7]
//输出：[[5,7]]
// 
//
// 示例 4： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,3]
//输出：[[1,5]]
// 
//
// 示例 5： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,7]
//输出：[[1,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 10⁵ 
// intervals 根据 intervals[i][0] 按 升序 排列 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 10⁵ 
// 
//
// Related Topics 数组 👍 788 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-08-28 20:40:36
 */
public class InsertInterval{
    public static void main(String[] args) {
        Solution solution = new InsertInterval().new Solution();
        System.out.println(solution.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        result.add(newInterval);
        for (int[] interval : intervals) {
            int[] last = result.get(result.size() - 1);
            if (interval[1] < last[0] || interval[0] > last[1]) {
                int index = interval[1] < last[0] ? (result.size() - 1) : result.size();
                result.add(index, interval);
            } else {
                last[0] = Math.min(interval[0], last[0]);
                last[1] = Math.max(interval[1], last[1]);
            }
        }
        int[][] ans = new int[result.size()][2];
        result.toArray(ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}