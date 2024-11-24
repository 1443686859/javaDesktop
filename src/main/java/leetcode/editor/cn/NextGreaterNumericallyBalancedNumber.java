//如果整数 x 满足：对于每个数位 d ，这个数位 恰好 在 x 中出现 d 次。那么整数 x 就是一个 数值平衡数 。 
//
// 给你一个整数 n ，请你返回 严格大于 n 的 最小数值平衡数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：22
//解释：
//22 是一个数值平衡数，因为：
//- 数字 2 出现 2 次 
//这也是严格大于 1 的最小数值平衡数。
// 
//
// 示例 2： 
//
// 
//输入：n = 1000
//输出：1333
//解释：
//1333 是一个数值平衡数，因为：
//- 数字 1 出现 1 次。
//- 数字 3 出现 3 次。 
//这也是严格大于 1000 的最小数值平衡数。
//注意，1022 不能作为本输入的答案，因为数字 0 的出现次数超过了 0 。 
//
// 示例 3： 
//
// 
//输入：n = 3000
//输出：3133
//解释：
//3133 是一个数值平衡数，因为：
//- 数字 1 出现 1 次。
//- 数字 3 出现 3 次。 
//这也是严格大于 3000 的最小数值平衡数。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁶ 
// 
//
// Related Topics 数学 回溯 枚举 👍 26 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-12-09 00:36:11
 */
public class NextGreaterNumericallyBalancedNumber{
    public static void main(String[] args) {
        Solution solution = new NextGreaterNumericallyBalancedNumber().new Solution();
//        System.out.println(solution.nextBeautifulNumber(1));
//        System.out.println(solution.maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2}, 2));
        System.out.println(solution.numberOfSets(3,5, new int[][]{{0,1,2},{1,2,10},{0,2,10}}));
    }
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int nextBeautifulNumber(int n) {
        n++;
        while (!check(n)) {
            n++;
        }
        return n;
    }
    public boolean check(int i) {
        int sum = 0;
        int[] count = new int[10];
        while (i != 0) {
            count[i %  10]++;
            i /= 10;
            sum++;
        }
        int current = 0;
        for (int j = 0; j < 10; j++) {
            if (count[j] == j) {
                current += count[j];
            }
        }
        return sum == current;
    }

    public int maxSubarrayLength(int[] nums, int k) {
        int right = 0;
        int left = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;
        while (right < nums.length) {
            countMap.put(nums[right], countMap.getOrDefault(nums[right], 0) + 1);
            while (left <= right && countMap.getOrDefault(nums[right], 0) > k) {
                countMap.put(nums[left], countMap.get(nums[left]) - 1);
                if (countMap.get(nums[left]) == 0) {
                    countMap.remove(nums[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int max = 1 << n;
        int count = 0;
        for (int i = 0; i < max; i++) {
            int mask = i;
            if (check(mask, n, maxDistance, roads)) {
                count++;
            }
        }
        return count;
    }
    public boolean check(int mask, int n, int maxDistance, int[][] roads) {
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }
        int current = mask ^ ((1 << n) - 1);
        if ((current & (current - 1)) == 0) {
            return true;
        }
        for (int[] road : roads) {
            if (((1 << road[0]) & mask) == 0 && ((1 << road[1]) & mask) == 0) {
                d[road[0]][road[1]] = d[road[0]][road[1]] == 0 ? road[2] : Math.min(d[road[0]][road[1]], road[2]);
                d[road[1]][road[0]] = d[road[0]][road[1]];
            }
        }
        for (int i = 0; i < n; i++) {
            if (((1 << i) & mask) != 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (((1 << j) & mask) != 0) {
                    continue;
                }
                for (int z = 0; z < n; z ++) {
                    if (((1 << j) & mask) != 0 || j == z || d[j][i] == Integer.MAX_VALUE || d[i][z] == Integer.MAX_VALUE) {
                        continue;
                    }
                    d[j][z] = Math.min(d[j][z], d[j][i] + d[i][z]);
                    d[z][j] = d[j][z];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (((1 << i) & mask) != 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (((1 << j) & mask) != 0 || i == j) {
                    continue;
                }
                if (d[i][j] > maxDistance) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}