//给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。 
//
// 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。 
//
// 子数组 定义为原数组中连续的一组元素。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,1,4,2], p = 6
//输出：1
//解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
// 
//
// 示例 2： 
//
// 输入：nums = [6,3,5,2], p = 9
//输出：2
//解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3], p = 3
//输出：0
//解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
// 
//
// 示例 4： 
//
// 输入：nums = [1,2,3], p = 7
//输出：-1
//解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
// 
//
// 示例 5： 
//
// 输入：nums = [1000000000,1000000000,1000000000], p = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= p <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 76 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en



import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-03-10 01:02:27
 */
public class MakeSumDivisibleByP{
    public static void main(String[] args) {
        Solution solution = new MakeSumDivisibleByP().new Solution();
        System.out.println(solution.minSubarray(new int[]{8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2}, 148));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }
        int preSum = 0;
        int d = (int)(totalSum % p);
        if (d == 0) {
            return 0;
        }
        int min = n;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, - 1);
        for (int i = 0; i < n; i++) {
            preSum = (preSum + nums[i] % p) % p;
            min = Math.min(min, i - preSumMap.getOrDefault((preSum - d + p) % p, - n));
            preSumMap.put(preSum, i);
        }
        return min == n ? - 1 : min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}