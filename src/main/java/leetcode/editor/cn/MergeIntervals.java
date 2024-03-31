//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2014 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-08-27 10:06:32
 */
public class MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        System.out.println(solution.minimumPossibleSum(16, 6));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (pre, after) -> {
            if (pre[0] != after[0]) {
                return pre[0] - after[0];
            } else {
                return pre[1] - after[1];
            }
        });
        List<int[]> result = new ArrayList<>();
        for (int[] i : intervals) {
            if (result.size() == 0) {
                result.add(i);
            } else {
                int[] pre = result.get(result.size() - 1);
                if (pre[0] <= i[0] && pre[1] >= i[0]) {
                    pre[1] = Math.max(pre[1], i[1]);
                } else {
                    result.add(i);
                }
            }
        }
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
    public long minimumPossibleSum(int n, int target) {
        long ans = 0;
        ans = (n + 1) * n / 2;
        int left = 1;
        int right = n;
        int next = n + 1;

        while (left < right) {
            if (target - right >= left && target - right < right) {
                ans -= right;
                while (target - next >= left && target - next < right) {
                    next++;
                }
                ans += next;
                next++;
            }
            right --;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}