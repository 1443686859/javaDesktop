//给你一个二维整数数组 ranges ，其中 ranges[i] = [starti, endi] 表示 starti 到 endi 之间（包括二者）的所有整
//数都包含在第 i 个区间中。 
//
// 你需要将 ranges 分成 两个 组（可以为空），满足： 
//
// 
// 每个区间只属于一个组。 
// 两个有 交集 的区间必须在 同一个 组内。 
// 
//
// 如果两个区间有至少 一个 公共整数，那么这两个区间是 有交集 的。 
//
// 
// 比方说，区间 [1, 3] 和 [2, 5] 有交集，因为 2 和 3 在两个区间中都被包含。 
// 
//
// 请你返回将 ranges 划分成两个组的 总方案数 。由于答案可能很大，将它对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：ranges = [[6,10],[5,15]]
//输出：2
//解释：
//两个区间有交集，所以它们必须在同一个组内。
//所以有两种方案：
//- 将两个区间都放在第 1 个组中。
//- 将两个区间都放在第 2 个组中。
// 
//
// 示例 2： 
//
// 输入：ranges = [[1,3],[10,20],[2,5],[4,8]]
//输出：4
//解释：
//区间 [1,3] 和 [2,5] 有交集，所以它们必须在同一个组中。
//同理，区间 [2,5] 和 [4,8] 也有交集，所以它们也必须在同一个组中。
//所以总共有 4 种分组方案：
//- 所有区间都在第 1 组。
//- 所有区间都在第 2 组。
//- 区间 [1,3] ，[2,5] 和 [4,8] 在第 1 个组中，[10,20] 在第 2 个组中。
//- 区间 [1,3] ，[2,5] 和 [4,8] 在第 2 个组中，[10,20] 在第 1 个组中。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ranges.length <= 10⁵ 
// ranges[i].length == 2 
// 0 <= starti <= endi <= 10⁹ 
// 
//
// Related Topics 数组 排序 👍 49 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-03-27 20:24:08
 */
public class CountWaysToGroupOverlappingRanges{
    public static void main(String[] args) {
        Solution solution = new CountWaysToGroupOverlappingRanges().new Solution();
        System.out.println(solution.countWays(new int[][]{{34,56},{28,29},{12,16},{11,48},{28,54},{22,55},{28,41},{41,44}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int MOD = 1_000_000_007;
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int count = 1;
        int maxRight = ranges[0][1];
        for (int i = 1; i < ranges.length; i++) {
            if (ranges[i][0] > maxRight) {
                count++;
            }
            maxRight = Math.max(maxRight, ranges[i][1]);
        }
        return fastPow(2, count);
    }
    public int fastPow(int base, int pow) {
        long result = 1L;
        long b = 1L * base;
        while (pow != 0) {
            if ((pow & 1) == 1) {
                result = (result * b) % MOD;
            }
            b = (b * b) % MOD;
            pow >>= 1;
        }
        return (int) result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}