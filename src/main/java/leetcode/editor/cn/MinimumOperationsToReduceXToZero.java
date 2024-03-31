//给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改
// 数组以供接下来的操作使用。 
//
// 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,4,2,3], x = 5
//输出：2
//解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,6,7,8,9], x = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,2,20,1,1,3], x = 10
//输出：5
//解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 1 <= x <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 二分查找 前缀和 滑动窗口 👍 191 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-01-07 14:07:57
 */
public class MinimumOperationsToReduceXToZero{
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToReduceXToZero().new Solution();
        System.out.println(solution.minOperations(new int[]{8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309}, 134365));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums, int x) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int[] sum = new int[nums.length];
        int result = 0;

        sum[0] = nums[0];
        sumMap.put(0, -1);
        sumMap.put(sum[0], 0);
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i- 1] +nums[i];
            sumMap.put(sum[i], i);
        }
        int target = sum[nums.length - 1] - x;
        if (target == 0) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum[i] >= target) {
                result = Math.max(result, i - sumMap.getOrDefault(sum[i] - target, i));
            }
        }
        if (result == 0) {
            return -1;
        }
        return nums.length - result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}