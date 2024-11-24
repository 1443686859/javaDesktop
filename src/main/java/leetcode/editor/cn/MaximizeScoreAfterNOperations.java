//给你 nums ，它是一个大小为 2 * n 的正整数数组。你必须对这个数组执行 n 次操作。 
//
// 在第 i 次操作时（操作编号从 1 开始），你需要： 
//
// 
// 选择两个元素 x 和 y 。 
// 获得分数 i * gcd(x, y) 。 
// 将 x 和 y 从 nums 中删除。 
// 
//
// 请你返回 n 次操作后你能获得的分数和最大为多少。 
//
// 函数 gcd(x, y) 是 x 和 y 的最大公约数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2]
//输出：1
//解释：最优操作是：
//(1 * gcd(1, 2)) = 1
// 
//
// 示例 2： 
//
// 输入：nums = [3,4,6,8]
//输出：11
//解释：最优操作是：
//(1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,5,6]
//输出：14
//解释：最优操作是：
//(1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 7 
// nums.length == 2 * n 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 位运算 数组 数学 动态规划 回溯 状态压缩 数论 👍 79 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2022-12-22 21:03:54
 */
public class MaximizeScoreAfterNOperations{
    public static void main(String[] args) {
        Solution solution = new MaximizeScoreAfterNOperations().new Solution();
        System.out.println(solution.maxScore(new int[]{773274,313112,131789,222437,918065,49745,321270,74163,900218,80160,325440,961730}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int result;
        int[] meno;
    public int maxScore(int[] nums) {
        int n = nums.length;
        meno = new int[1 << n];
        int[][] count = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                    if (count[j][i] != 0) {
                        count[i][j] = count[j][i];
                    } else {
                        count[i][j] = gcd(nums[i], nums[j]);
                    }
            }
        }
        return dfs(count, (1 << n) - 1,  n / 2, 0);
    }
    public int dfs(int[][] count, int mask, int currentIndex, int currentResult) {
        if (currentIndex == 0) {
            return currentResult;
        }
        if (meno[mask] > 0) {
            return currentResult + meno[mask];
        }
        int n = count.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                continue;
            }
            for (int j = i + 1; j < n; j ++) {
                if ((mask & (1 << j)) == 0) {
                    continue;
                }
                int temp = mask ^ (1 << i) ^ (1 << j);
                ans = Math.max(ans, dfs(count, temp, currentIndex - 1, currentResult + count[i][j] * currentIndex));
            }
        }
        meno[mask] = ans - currentResult;
        return ans;
    }
    public int gcd(int pre, int after) {
        int max = Math.max(pre, after);
        int min = Math.min(pre, after);
        if (max % min == 0) {
            return min;
        } else {
            return gcd(max % min, min);
        }
    }


    private void fillDp(int n, int max, int[][] count, int[] dp) {
        for (int i = 1; i < max; i++) {
            int current = Integer.bitCount(i);
            if ((current & 1) != 0) {
                continue;
            }
            int currentIndex = current / 2;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    for (int z = j + 1; z < n; z++) {
                        if ((i & (1 << z)) != 0) {
                            dp[i] = Math.max(dp[i], dp[i ^ (1 << j) ^ (1 << z)] + currentIndex * count[j][z]);
                        }
                    }
                }

            }
        }
    }

    public int oneCount(int current) {
        int result = 0;
        while (current != 0) {
            if ((current & 1) != 0) {
                result++;
            }
            current >>= 1;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}