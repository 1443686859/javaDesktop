//给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与 
//nums[j] 的数位和相等。 
//
// 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [18,43,36,13,7]
//输出：54
//解释：满足条件的数对 (i, j) 为：
//- (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
//- (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
//所以可以获得的最大和是 54 。 
//
// 示例 2： 
//
// 
//输入：nums = [10,12,19,14]
//输出：-1
//解释：不存在满足条件的数对，返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 排序 堆（优先队列） 👍 56 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-11-18 17:40:50
 */
public class MaxSumOfAPairWithEqualSumOfDigits{
    public static void main(String[] args) {
        Solution solution = new MaxSumOfAPairWithEqualSumOfDigits().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, int[]> result = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = 0;
            int temp = nums[i];
            while (temp != 0) {
                current += temp % 10;
                temp /= 10;
            }
            int[] a = result.getOrDefault(current, new int[2]);
            if (nums[i] > a[0]) {
                a[1] = a[0];
                a[0] = nums[i];
            } else if (nums[i] > a[1]) {
                a[1] = nums[i];
            }
            result.put(current, a);
            if (a[0] != 0 && a[1] != 0) {
                max = Math.max(max, a[0] + a[1]);
            }
        }
        return max == 0 ? - 1 : max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}