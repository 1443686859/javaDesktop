//给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为 
//firstLen 和 secondLen 。 
//
// 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。 
//
// 子数组是数组的一个 连续 部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
//输出：20
//解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
//输出：29
//解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
//输出：31
//解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= firstLen, secondLen <= 1000 
// 2 <= firstLen + secondLen <= 1000 
// firstLen + secondLen <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 滑动窗口 👍 241 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-04-26 21:18:34
 */
public class MaximumSumOfTwoNonOverlappingSubarrays{
    public static void main(String[] args) {
        Solution solution = new MaximumSumOfTwoNonOverlappingSubarrays().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] firstCount = new int[n + 1];
        int[] secondCount = new int[n + 1];
        int[] sum = new int[n + 1];
        int maxFirst = 0;
        int maxSecond = 0;
        int firstSum = 0;
        int secondSum = 0;
        for (int i = 0; i < n; i ++) {
            firstSum += nums[i];
            secondSum += nums[i];
            if (i >= firstLen) {
                firstSum -= nums[i - firstLen];
            }
            if (i >= secondLen) {
                secondSum -= nums[i - secondLen];
            }
            maxFirst = Math.max(firstSum, maxFirst);
            maxSecond = Math.max(maxSecond, secondSum);
            firstCount[i + 1] = maxFirst;
            secondCount[i + 1] = maxSecond;
            sum[i + 1] = sum[i] + nums[i];
        }
        int max = 0;
        for (int i = firstLen + secondLen - 1; i < n; i ++) {
            max = Math.max(max, Math.max(sum[i + 1]- sum[i + 1 - firstLen] + secondCount[i + 1 - firstLen], sum[i + 1]- sum[i + 1 - secondLen] + firstCount[i + 1 - secondLen]));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}