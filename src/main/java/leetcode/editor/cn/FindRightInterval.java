//给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。 
//
// 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。 
//
// 返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -
//1 。 
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,2]]
//输出：[-1]
//解释：集合中只有一个区间，所以输出-1。
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[3,4],[2,3],[1,2]]
//输出：[-1,0,1]
//解释：对于 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间[3,4]具有最小的“右”起点;
//对于 [1,2] ，区间[2,3]具有最小的“右”起点。
// 
//
// 示例 3： 
//
// 
//输入：intervals = [[1,4],[2,3],[3,4]]
//输出：[-1,2,-1]
//解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 2 * 10⁴ 
// intervals[i].length == 2 
// -10⁶ <= starti <= endi <= 10⁶ 
// 每个间隔的起点都 不相同 
// 
// Related Topics 数组 二分查找 排序 👍 167 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-05-20 22:23:54
 */
public class FindRightInterval{
    public static void main(String[] args) {
        Solution solution = new FindRightInterval().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[][] start = new int[intervals.length][intervals[0].length];
        for (int i = 0; i < intervals.length; i++) {
            start[i][0] = intervals[i][0];
            start[i][1] = i;
        }
        Arrays.sort(start, (a, b) -> {
            return a[0] - b[0];
        });
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int current = intervals[i][1];
            int left = 0;
            int right =  intervals.length - 1;
            int target = -1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (start[mid][0] >= current) {
                    target = start[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = target;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}