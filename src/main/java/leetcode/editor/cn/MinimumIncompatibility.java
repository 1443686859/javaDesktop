//给你一个整数数组 nums 和一个整数 k 。你需要将这个数组划分到 k 个相同大小的子集中，使得同一个子集里面没有两个相同的元素。 
//
// 一个子集的 不兼容性 是该子集里面最大值和最小值的差。 
//
// 请你返回将数组分成 k 个子集后，各子集 不兼容性 的 和 的 最小值 ，如果无法分成分成 k 个子集，返回 -1 。 
//
// 子集的定义是数组中一些数字的集合，对数字顺序没有要求。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,4], k = 2
//输出：4
//解释：最优的分配是 [1,2] 和 [1,4] 。
//不兼容性和为 (2-1) + (4-1) = 4 。
//注意到 [1,1] 和 [2,4] 可以得到更小的和，但是第一个集合有 2 个相同的元素，所以不可行。 
//
// 示例 2： 
//
// 
//输入：nums = [6,3,8,1,3,1,2,2], k = 4
//输出：6
//解释：最优的子集分配为 [1,2]，[2,3]，[6,8] 和 [1,3] 。
//不兼容性和为 (2-1) + (3-2) + (8-6) + (3-1) = 6 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,3,3,6,3,3], k = 3
//输出：-1
//解释：没办法将这些数字分配到 3 个子集且满足每个子集里没有相同数字。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 16 
// nums.length 能被 k 整除。 
// 1 <= nums[i] <= nums.length 
// 
//
// Related Topics 位运算 数组 动态规划 状态压缩 👍 109 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-06-28 19:28:29
 */
public class MinimumIncompatibility{
    public static void main(String[] args) {
        Solution solution = new MinimumIncompatibility().new Solution();
        System.out.println(solution.minimumIncompatibility(new int[]{11,11,3,4,2,16,14,13,6,14,2,5,10,13,5,7}, 8));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] memo;
        int maxLength;
        int[] values;
    public int minimumIncompatibility(int[] nums, int k) {
        int i = (1 << nums.length) - 1;
        int n = nums.length;
        maxLength = nums.length / k;
        memo = new int[k + 1][i + 1];
        for (int j = 0 ;j <= k; j++) {
            Arrays.fill(memo[j], Integer.MAX_VALUE);
        }
        values = new int[1 << n];
        Arrays.fill(values, - 1);
        for (int j = i; j > 0; j = i & (j - 1)) {
           if (check(j, nums)) {
               values[j] = get(j, nums);
           }
        }
        return dfs(i, k, nums);
    }
    int dfs(int current, int index, int[] arr) {
        int n = arr.length;
        if (memo[index][current] != Integer.MAX_VALUE) {
            return memo[index][current];
        }
        if (index == 0) {
            if (current != 0) {
                return -1;
            }
            return 0;
        }
        if (current == 0 && index != 0) {
            return -1;
        }
        if (getLength(current) == index) {
            return 0;
        }
        int[] count = new int[n + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if ((current & (1 << i)) != 0) {
                count[arr[n - 1 - i]]++;
                max = Math.max(max, count[arr[n - 1 - i]]);
            }
        }
        if (max > index) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int i = current; i > 0; i = current & (i - 1)) {
            if (values[i] != -1) {
                int nowResult = dfs(current & (~i), index - 1, arr);
                if (nowResult != -1) {
                    result = Math.min(result, values[i] + nowResult);
                }
            }
        }
        result = result == Integer.MAX_VALUE ? - 1 : result;
        memo[index][current] = result;
        return result;
    }
    int get(int current, int[] arr) {
        int max = -1;
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if ((current & (1 << i)) != 0) {
                max = Math.max(max, arr[n - 1 - i]);
                min = Math.min(min, arr[n - i - 1]);
            }
        }
        return max - min;
    }
    boolean check(int current, int[] arr) {
        int[] count = new int[arr.length + 1];
        int n = arr.length;
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((current & (1 << i)) != 0) {
                count[arr[n - 1- i]]++;
                length++;
                if (count[arr[n - 1- i]] >= 2) {
                    return false;
                }
            }
        }
        return length == maxLength;
    }
    int getLength(int current) {
        int count = 0;
        while (current != 0) {
            if ((current & 1) != 0) {
                count++;
            }
            current >>= 1;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}