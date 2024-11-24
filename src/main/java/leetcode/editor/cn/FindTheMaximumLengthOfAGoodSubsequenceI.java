/**
给你一个整数数组 nums 和一个 非负 整数 k 。如果一个整数序列 seq 满足在下标范围 [0, seq.length - 2] 中 最多只有 k 个下标
 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。 

 请你返回 nums 中 好 子序列 的最长长度。 

 

 示例 1： 

 
 输入：nums = [1,2,1,1,3], k = 2 
 

 输出：4 

 解释： 

 最长好子序列为 [1,2,1,1,3] 。 

 示例 2： 

 
 输入：nums = [1,2,3,4,5,1], k = 0 
 

 输出：2 

 解释： 

 最长好子序列为 [1,2,3,4,5,1] 。 

 

 提示： 

 
 1 <= nums.length <= 500 
 1 <= nums[i] <= 10⁹ 
 0 <= k <= min(nums.length, 25) 
 

 👍 38 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2024-09-06 22:07:00
 */
public class FindTheMaximumLengthOfAGoodSubsequenceI{
    public static void main(String[] args) {
        Solution solution = new FindTheMaximumLengthOfAGoodSubsequenceI().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = 0;
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, m++);
            }
        }
        int[][] dp = new int[m][k + 1];
        int[][][] a = new int[k + 1][2][2];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = map.get(nums[i]);
            dp[index][0]++;
            max= Math.max(max, dp[index][0]);
            update(a[0], index, dp[index][0]);
            for (int j = 1; j <= Math.min(i, k); j++) {
                int[][] current = a[j - 1];
                int maxIndex = current[0][0] == index ? 1 : 0;
                dp[index][j] = Math.max(dp[index][j] + 1, current[maxIndex][1] + 1);
                max = Math.max(dp[index][j], max);
                update(a[j], index, dp[index][j]);
            }
        }
        return max;

    }
    public void update(int[][] current, int index, int value) {
        if (current[0][0] == index) {
            current[0][1] = value;
            return;
        }
        if (current[1][0] == index) {
            current[1][1] = value;
            if (current[1][1] > current[0][1]) {
                int[] temp = new int[]{current[0][0], current[0][1]};
                current[0] = current[1];
                current[1] = temp;
            }
            return;
        }
        int[] temp = new int[]{index, value};
        if (current[0][1] < value) {
            int[] newTemp = new int[]{current[0][0], current[0][1]};
            current[0] = temp;
            current[1] = newTemp;
        } else if (current[1][1] < value) {
            current[1] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}