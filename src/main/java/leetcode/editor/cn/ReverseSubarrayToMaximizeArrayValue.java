//给你一个整数数组 nums 。「数组值」定义为所有满足 0 <= i < nums.length-1 的 |nums[i]-nums[i+1]| 的和。 
//
// 你可以选择给定数组的任意子数组，并将该子数组翻转。但你只能执行这个操作 一次 。 
//
// 请你找到可行的最大 数组值 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,3,1,5,4]
//输出：10
//解释：通过翻转子数组 [3,1,5] ，数组变成 [2,5,1,3,4] ，数组值为 10 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,4,9,24,2,1,10]
//输出：68
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3*10^4 
// -10^5 <= nums[i] <= 10^5 
// 
//
// Related Topics 贪心 数组 数学 👍 149 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-05-12 22:11:25
 */
public class ReverseSubarrayToMaximizeArrayValue{
    public static void main(String[] args) {
        Solution solution = new ReverseSubarrayToMaximizeArrayValue().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int base = 0;
        int d = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int a = nums[i - 1];
            int b = nums[i];
            base += Math.abs(b - a);
            min = Math.min(min, Math.max(a,b));
            max = Math.max(max, Math.min(a,b));
            d = Math.max(d, Math.max(Math.abs(nums[0] - b) - Math.abs(a - b), Math.abs(nums[n - 1] - a) - Math.abs(a - b)));
        }
        return base + Math.max(d, 2 * (max - min));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}