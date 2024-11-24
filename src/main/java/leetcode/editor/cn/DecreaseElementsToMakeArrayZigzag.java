//给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。 
//
// 如果符合下列情况之一，则数组 A 就是 锯齿数组： 
//
// 
// 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ... 
// 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ... 
// 
//
// 返回将数组 nums 转换为锯齿数组所需的最小操作次数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3]
//输出：2
//解释：我们可以把 2 递减到 0，或把 3 递减到 1。
// 
//
// 示例 2： 
//
// 输入：nums = [9,6,1,6,2]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 贪心 数组 👍 107 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-02-27 21:50:08
 */
public class DecreaseElementsToMakeArrayZigzag{
    public static void main(String[] args) {
        Solution solution = new DecreaseElementsToMakeArrayZigzag().new Solution();
        System.out.println(solution.movesToMakeZigzag(new int[]{9,6,1,6,2}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int oddResult = 0;
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        for (int i = 1; i < n; i += 2) {
            if (i == n - 1) {
                if (nums[i - 1] <= nums[i]) {
                    oddResult += nums[i] - (nums[i - 1] - 1);
                }
            } else {
                int min = Math.min(nums[i - 1], nums[i + 1]);
                if (nums[i] >= min) {
                    oddResult += nums[i] - (min - 1);
                }
            }
        }
        int oResult = 0;
        for (int i = 0; i < n; i += 2) {
            if (i == n - 1) {
                if (nums[i - 1] <= nums[i]) {
                    oResult += nums[i] - (nums[i - 1] - 1);
                }
            } else {
                if (i == 0) {
                    if (i + 1 < n && nums[i] >= nums[i + 1]) {
                        oResult += nums[i] - (nums[i + 1] - 1);
                    }
                } else {
                    int min = Math.min(nums[i - 1], nums[i + 1]);
                    if (nums[i] >= min) {
                        oResult += nums[i] - (min - 1);
                    }

                }
            }
        }
        return Math.min(oddResult, oResult);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}