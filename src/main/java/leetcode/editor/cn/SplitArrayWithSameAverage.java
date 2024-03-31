//给定你一个整数数组
// nums 
//
// 我们要将
// nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和
// B 数组不为空，并且
// average(A) == average(B) 。 
//
// 如果可以完成则返回true ， 否则返回 false 。 
//
// 注意：对于数组
// arr , 
// average(arr) 是
// arr 的所有元素的和除以
// arr 长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7,8]
//输出: true
//解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
// 
//
// 示例 2: 
//
// 
//输入: nums = [3,1]
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 30 
// 0 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 位运算 数组 数学 动态规划 状态压缩 👍 231 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashSet;
import java.util.Set;

/**
 * @author  YourName
 * @date 2022-11-14 20:06:19
 */
public class SplitArrayWithSameAverage{
    public static void main(String[] args) {
        Solution solution = new SplitArrayWithSameAverage().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = n * nums[i] - sum;
        }
        int m = n / 2;
        Set<Integer> count = new HashSet<>();
        for (int i = 1; i < (1 << m); i++) {
            int currentTotal = 0;
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    currentTotal += nums[j];
                }
            }
            if (currentTotal == 0) {
                return true;
            }
            count.add(currentTotal);
        }
        int rightSum = 0;
        for (int i = m; i < n; i++) {
            rightSum += nums[i];
        }
        for (int i = 1; i < (1 << (n  - m)); i++) {
            int rightTotal = 0;
            for (int j = m; j < n; j++) {
                if ((i & (1 << (j - m))) != 0) {
                    rightTotal += nums[j];
                }
            }
            if (rightTotal == 0 || (rightSum != rightTotal && count.contains(- rightTotal))) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}