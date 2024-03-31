//共有 k 位工人计划将 n 个箱子从旧仓库移动到新仓库。给你两个整数 n 和 k，以及一个二维整数数组 time ，数组的大小为 k x 4 ，其中 
//time[i] = [leftToRighti, pickOldi, rightToLefti, putNewi] 。 
//
// 一条河将两座仓库分隔，只能通过一座桥通行。旧仓库位于河的右岸，新仓库在河的左岸。开始时，所有 k 位工人都在桥的左侧等待。为了移动这些箱子，第 i 位工人
//（下标从 0 开始）可以： 
//
// 
// 从左岸（新仓库）跨过桥到右岸（旧仓库），用时 leftToRighti 分钟。 
// 从旧仓库选择一个箱子，并返回到桥边，用时 pickOldi 分钟。不同工人可以同时搬起所选的箱子。 
// 从右岸（旧仓库）跨过桥到左岸（新仓库），用时 rightToLefti 分钟。 
// 将箱子放入新仓库，并返回到桥边，用时 putNewi 分钟。不同工人可以同时放下所选的箱子。 
// 
//
// 如果满足下面任一条件，则认为工人 i 的 效率低于 工人 j ： 
//
// 
// leftToRighti + rightToLefti > leftToRightj + rightToLeftj 
// leftToRighti + rightToLefti == leftToRightj + rightToLeftj 且 i > j 
// 
//
// 工人通过桥时需要遵循以下规则： 
//
// 
// 如果工人 x 到达桥边时，工人 y 正在过桥，那么工人 x 需要在桥边等待。 
// 如果没有正在过桥的工人，那么在桥右边等待的工人可以先过桥。如果同时有多个工人在右边等待，那么 效率最低 的工人会先过桥。 
// 如果没有正在过桥的工人，且桥右边也没有在等待的工人，同时旧仓库还剩下至少一个箱子需要搬运，此时在桥左边的工人可以过桥。如果同时有多个工人在左边等待，那么 
//效率最低 的工人会先过桥。 
// 
//
// 所有 n 个盒子都需要放入新仓库，请你返回最后一个搬运箱子的工人 到达河左岸 的时间。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1, k = 3, time = [[1,1,2,1],[1,1,3,1],[1,1,4,1]]
//输出：6
//解释：
//从 0 到 1 ：工人 2 从左岸过桥到达右岸。
//从 1 到 2 ：工人 2 从旧仓库搬起一个箱子。
//从 2 到 6 ：工人 2 从右岸过桥到达左岸。
//从 6 到 7 ：工人 2 将箱子放入新仓库。
//整个过程在 7 分钟后结束。因为问题关注的是最后一个工人到达左岸的时间，所以返回 6 。
// 
//
// 示例 2： 
//
// 
//输入：n = 3, k = 2, time = [[1,9,1,8],[10,10,10,10]]
//输出：50
//解释：
//从 0 到 10 ：工人 1 从左岸过桥到达右岸。
//从 10 到 20 ：工人 1 从旧仓库搬起一个箱子。
//从 10 到 11 ：工人 0 从左岸过桥到达右岸。
//从 11 到 20 ：工人 0 从旧仓库搬起一个箱子。
//从 20 到 30 ：工人 1 从右岸过桥到达左岸。
//从 30 到 40 ：工人 1 将箱子放入新仓库。
//从 30 到 31 ：工人 0 从右岸过桥到达左岸。
//从 31 到 39 ：工人 0 将箱子放入新仓库。
//从 39 到 40 ：工人 0 从左岸过桥到达右岸。
//从 40 到 49 ：工人 0 从旧仓库搬起一个箱子。
//从 49 到 50 ：工人 0 从右岸过桥到达左岸。
//从 50 到 58 ：工人 0 将箱子放入新仓库。
//整个过程在 58 分钟后结束。因为问题关注的是最后一个工人到达左岸的时间，所以返回 50 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n, k <= 10⁴ 
// time.length == k 
// time[i].length == 4 
// 1 <= leftToRighti, pickOldi, rightToLefti, putNewi <= 1000 
// 
//
// Related Topics 数组 模拟 堆（优先队列） 👍 73 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author  YourName
 * @date 2023-07-07 22:11:45
 */
public class TimeToCrossABridge{
    public static void main(String[] args) {
        Solution solution = new TimeToCrossABridge().new Solution();
//        System.out.println(solution.findCrossingTime(10,6, new int[][]{{2,10,5,8},{3,5,2,2},{5,8,10,10},{7,8,8,5},{5,6,6,10},{6,10,6,2}}));
        System.out.println(solution.maxNonDecreasingLength(new int[]{2,3,1}, new int[]{1,2,1}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        return 0;
    }
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        List<Integer> result = set.stream().collect(Collectors.toList());
        result.sort((a, b) -> {
            return a- b;
        });

//        return set.stream().collect(Collectors.toList()).sort();
        return new ArrayList<>();

    }

    int[] memo;
    Set<Integer> set;
    public int minimumBeautifulSubstrings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, s.length());
        set = new HashSet<>();
        set.add(1);
        int start = 5;
        for (int i = 0; i < 7; i++) {
            set.add(start);
            start *= 5;
        }
        int result = get(s, 0);
        return result > s.length() ? -1 : result;
    }
    public int get(String s, int current) {
        if (current >= s.length()) {
            return 0;
        }
        if (memo[current] != s.length()) {
            return memo[current];
        }
        if (s.charAt(current) == '0') {
            return s.length();
        }
        int start = current;
        int result = 0;
        int min = s.length();

        while (start < s.length()) {
           result = result * 2 + s.charAt(start) - '0';
            if (set.contains(result)) {
                min = Math.min(min, 1 + get(s, start+ 1));
            }
            start++;
        }
        memo[current] = min;
        return min;
    }

    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] result = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], -1);
        }
        result[0][0] = 1;
        result[0][1] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (nums1[i] >= nums1[i - 1]) {
                result[i][0] = Math.max(result[i][0], result[i - 1][0] + 1);
            }
            if (nums1[i] >= nums2[i - 1]) {
                result[i][0] = Math.max(result[i][0], result[i - 1][1] + 1);
            }
            if (result[i][0] == -1) {
                result[i][0] = 1;
            }

            if (nums2[i] >= nums1[i - 1]) {
                result[i][1] = Math.max(result[i][1], result[i - 1][0] + 1);
            }
            if (nums2[i] >= nums2[i - 1]) {
                result[i][1] = Math.max(result[i][1], result[i - 1][1] + 1);
            }
            if (result[i][1] == -1) {
                result[i][1] = 1;
            }
            ans = Math.max(ans, Math.max(result[i][0], result[i][1]));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}