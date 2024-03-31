//给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n² 分钟内修好
// n 辆车。 
//
// 同时给你一个整数 cars ，表示总共需要修理的汽车数目。 
//
// 请你返回修理所有汽车 最少 需要多少时间。 
//
// 注意：所有机械工可以同时修理汽车。 
//
// 
//
// 示例 1： 
//
// 
//输入：ranks = [4,2,3,1], cars = 10
//输出：16
//解释：
//- 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
//- 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
//- 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
//- 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
//16 分钟是修理完所有车需要的最少时间。
// 
//
// 示例 2： 
//
// 
//输入：ranks = [5,1,8], cars = 6
//输出：16
//解释：
//- 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
//- 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
//- 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
//16 分钟时修理完所有车需要的最少时间。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ranks.length <= 10⁵ 
// 1 <= ranks[i] <= 100 
// 1 <= cars <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 👍 159 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author  YourName
 * @date 2023-09-07 21:31:00
 */
public class MinimumTimeToRepairCars{
    public static void main(String[] args) {
        Solution solution = new MinimumTimeToRepairCars().new Solution();
        int[] a = new int[1000000 / 10];
        Arrays.fill(a, 1);
        System.out.println(solution.repairCars(a, 1000000));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long repairCars1(int[] ranks, int cars) {
        PriorityQueue<long[]>  queue = new PriorityQueue<>((a, b) -> {
           long i1 = (a[1] + 1) * (a[1] + 1) * a[0];
           long i2 = (b[1] + 1) * (b[1] + 1) * b[0];
            if (i1 < i2) {
                return -1;
            } else if (i1 > i2) {
                return 1;
            } else {
                return 0;
            }
        });
        for (int i = 0; i < ranks.length; i++) {
            queue.add(new long[]{ranks[i], 0l});
        }
        if (queue.size() == 1) {
            long[] c = queue.poll();
            return c[0] * cars * cars;
        }
        long ans = 0;
        while (cars > 0) {
            long[] c = queue.poll();
            long[] c1 = queue.poll();
            long max = (long)Math.sqrt(c1[0] * (c1[1] + 1) * (c1[1] + 1) / c[0]);
            if (cars > max - c[1]) {
                cars -= max - c[1];
                c[1] = max;
            } else {
                c[1] += cars;
                cars = 0;
            }

            queue.add(c);
            queue.add(c1);
            ans = Math.max(ans, c[0] * c[1] * c[1]);

        }
        return ans;
    }
    public long repairCars(int[] ranks, int cars) {
        int min = Integer.MAX_VALUE;
        int[] count = new int[101];
        for (int i : ranks) {
            count[i]++;
            min = Math.min(min, i);
        }
        long left = 1l;
        long right = 1l * min * cars * cars;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = 0;
            for (int i = 1; i <= 100 && sum < cars; i++) {
                if (count[i] != 0) {
                    sum += (long) Math.sqrt(mid / i) * count[i];
                }
            }
            if (sum >= cars) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}