//给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。 
//
// 
// 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。 
// 
//
// 注意：0 既不是正整数也不是负整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,-1,-1,1,2,3]
//输出：3
//解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-3,-2,-1,0,0,1,2]
//输出：3
//解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,20,66,1314]
//输出：4
//解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2000 
// -2000 <= nums[i] <= 2000 
// nums 按 非递减顺序 排列。 
// 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(log(n)) 的算法解决此问题吗？ 
//
// Related Topics 数组 二分查找 计数 👍 24 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-04-09 22:14:12
 */
public class MaximumCountOfPositiveIntegerAndNegativeInteger{
    public static void main(String[] args) {
        Solution solution = new MaximumCountOfPositiveIntegerAndNegativeInteger().new Solution();
        System.out.println(solution.maximumCount(new int[]{5,20,66,1314}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumCount(int[] nums) {
        return Math.max(nums.length - search(nums, 1), search(nums,0));
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}