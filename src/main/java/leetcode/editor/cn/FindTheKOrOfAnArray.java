//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。 
//
// nums 中的 K-or 是一个满足以下条件的非负整数： 
//
// 
// 只有在 nums 中，至少存在 k 个元素的第 i 位值为 1 ，那么 K-or 中的第 i 位的值才是 1 。 
// 
//
// 返回 nums 的 K-or 值。 
//
// 注意 ：对于整数 x ，如果 (2ⁱ AND x) == 2ⁱ ，则 x 中的第 i 位值为 1 ，其中 AND 为按位与运算符。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,12,9,8,9,15], k = 4
//输出：9
//解释：nums[0]、nums[2]、nums[4] 和 nums[5] 的第 0 位的值为 1 。
//nums[0] 和 nums[5] 的第 1 位的值为 1 。
//nums[0]、nums[1] 和 nums[5] 的第 2 位的值为 1 。
//nums[1]、nums[2]、nums[3]、nums[4] 和 nums[5] 的第 3 位的值为 1 。
//只有第 0 位和第 3 位满足数组中至少存在 k 个元素在对应位上的值为 1 。因此，答案为 2^0 + 2^3 = 9 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,12,1,11,4,5], k = 6
//输出：0
//解释：因为 k == 6 == nums.length ，所以数组的 6-or 等于其中所有元素按位与运算的结果。因此，答案为 2 AND 12 AND 1
// AND 11 AND 4 AND 5 = 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [10,8,5,9,11,6,8], k = 1
//输出：15
//解释：因为 k == 1 ，数组的 1-or 等于其中所有元素按位或运算的结果。因此，答案为 10 OR 8 OR 5 OR 9 OR 11 OR 6 
//OR 8 = 15 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50 
// 0 <= nums[i] < 2³¹ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 位运算 数组 👍 24 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-03-06 21:50:30
 */
public class FindTheKOrOfAnArray{
    public static void main(String[] args) {
        Solution solution = new FindTheKOrOfAnArray().new Solution();
        System.out.println(solution.findKOr(new int[]{7,12,9,8,9,15}, 4));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKOr(int[] nums, int k) {
        int result = 0;
         
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int count = 0;
            for (int j : nums) {
                if ((j & mask) != 0) {
                    count++;
                }
            }
            result |= (count >= k) ? mask : 0;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}