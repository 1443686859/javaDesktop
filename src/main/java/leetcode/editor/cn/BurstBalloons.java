/**
有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 

 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1
 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 

 求所能获得硬币的最大数量。 

 
示例 1：

 
输入：nums = [3,1,5,8]
输出：167
解释：
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 

 示例 2： 

 
输入：nums = [1,5]
输出：10
 

 

 提示： 

 
 n == nums.length 
 1 <= n <= 300 
 0 <= nums[i] <= 100 
 

 👍 1346 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author  YourName
 * @date 2024-06-09 00:16:39
 */
public class BurstBalloons{
    public static void main(String[] args) {
        Solution solution = new BurstBalloons().new Solution();
        System.out.println(solution.maxCoins(new int[]{3,1,5,8}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] array = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            array[i] = nums[i - 1];
        }
        array[0] = array[n + 1] = 1;
        int[][] memo = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k ++) {
                    memo[i][j] = Math.max(memo[i][j], array[i] * array[j] * array[k] + memo[i][k] + memo[k][j]);
                }
            }
        }
        return memo[0][n + 1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}