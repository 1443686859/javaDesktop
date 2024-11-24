//给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组。 
//
// 设计一个算法使得这 k 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], k = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 
//其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], k = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], k = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁶ 
// 1 <= k <= min(50, nums.length) 
// 
//
// Related Topics 贪心 数组 二分查找 动态规划 前缀和 👍 891 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-01-21 13:09:18
 */
public class SplitArrayLargestSum{
    public static void main(String[] args) {
        Solution solution = new SplitArrayLargestSum().new Solution();
        System.out.println(solution.splitArray(new int[]{1,4,4}, 3));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitArray1(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        int[][] result = new int[n + 1][k + 1];
        for (int i = 0; i < n ; i++) {
            sum[i + 1] = sum[i] + nums[i];
            result[i + 1][1] = sum[i + 1];
        }
        for (int i = 0; i < n; i++) {
            for (int z = 2; z <= Math.min(k, i + 1); z++) {
                for (int j = z - 1; j <= i; j++) {
                    result[i + 1][z] = result[i + 1][z] == 0 ?  Math.max(result[j][z - 1], sum[i + 1] - sum[j]) : Math.min(result[i + 1][z], Math.max(result[j][z - 1], sum[i + 1] - sum[j]));
                }
            }
        }
        return result[n][k];
    }
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
            sum += i;
        }
        int left = Math.max(max, (sum - 1) / k);
        int right = sum;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(nums, mid, k)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }
    public boolean check(int[] nums, int target, int k) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                if (count == k) {
                    return false;
                }
                sum = nums[i];
                count++;
            } else {
                sum += nums[i];
            }
        }
        return count <= k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}