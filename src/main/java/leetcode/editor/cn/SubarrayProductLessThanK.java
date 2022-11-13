//给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,5,2,6], k = 100
//输出：8
//解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 0
//输出：0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
// Related Topics 数组 滑动窗口 👍 400 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-05-04 16:04:11
 */
public class SubarrayProductLessThanK{
    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK().new Solution();
        System.out.println(solution.numSubarrayProductLessThanK1(new int[]{1,1,1}, 1));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int preResult = 1;
        int result = 0;
        while (right < nums.length) {
            preResult *= nums[right];
            while (left <= right && preResult >= k) {
                preResult /= nums[left];
                left++;
            }
            result += (right - left + 1);
            right++;
        }
        return result;
    }
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        double target = Math.log(k);
        int n = nums.length;
        double[] preF = new double[n + 1];
        for (int i = 0; i < n; i++) {
            preF[i + 1] = preF[i] + Math.log(nums[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = i + 1;
            int currentResult = i + 1;
            double searchVal = preF[i + 1] - target + 1e-10;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (preF[mid] > searchVal) {
                    currentResult = mid;
                   right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result += i - currentResult + 1;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}