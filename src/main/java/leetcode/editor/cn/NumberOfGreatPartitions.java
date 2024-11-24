//给你一个正整数数组 nums 和一个整数 k 。 
//
// 分区 的定义是：将数组划分成两个有序的 组 ，并满足每个元素 恰好 存在于 某一个 组中。如果分区中每个组的元素和都大于等于 k ，则认为分区是一个好分区
//。 
//
// 返回 不同 的好分区的数目。由于答案可能很大，请返回对 10⁹ + 7 取余 后的结果。 
//
// 如果在两个分区中，存在某个元素 nums[i] 被分在不同的组中，则认为这两个分区不同。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4], k = 4
//输出：6
//解释：好分区的情况是 ([1,2,3], [4]), ([1,3], [2,4]), ([1,4], [2,3]), ([2,3], [1,4]), ([2
//,4], [1,3]) 和 ([4], [1,2,3]) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,3,3], k = 4
//输出：0
//解释：数组中不存在好分区。
// 
//
// 示例 3： 
//
// 
//输入：nums = [6,6], k = 2
//输出：2
//解释：可以将 nums[0] 放入第一个分区或第二个分区中。
//好分区的情况是 ([6], [6]) 和 ([6], [6]) 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, k <= 1000 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 动态规划 👍 20 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-01-03 22:26:24
 */
public class NumberOfGreatPartitions{
    public static void main(String[] args) {
        Solution solution = new NumberOfGreatPartitions().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPartitions(int[] nums, int k) {
        int  n = nums.length;
        int mod = (int)1e9 + 7;
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum < 2 * k) {
            return 0;
        }
        int result = 1;
//        int[][] array = new int[n + 1][k + 1];
//
//        array[0][0] = 1;
//        for (int i = 1; i <= n; i++) {
//            result = (result * 2) % mod;
//            for (int j = 0; j < k; j++) {
//                array[i][j] = array[i - 1][j];
//                if (j >= nums[i - 1]) {
//                    array[i][j] = (array[i][j] + array[i - 1][j - nums[i - 1]]) % mod;
//                }
//            }
//        }
//        for (int i = 0; i < k; i++) {
//            result = (result - (2 * array[n][i]) % mod + mod) % mod;
//        }
        int[] array = new int[k + 1];
        array[0] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            result = (result * 2) % mod;
            for (int  j = k - 1; j >= x; j--) {
                array[j] = (array[j] + array[j - x]) % mod;
            }
        }
        for (int i = 0; i < k; i++) {
            result = (result - (2 * array[i]) % mod + mod) % mod;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}