//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 
//
// 示例 2： 
//
// 输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 4 * 10^4 
// 1 <= nums[i] <= 10^4 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 288 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-06-19 22:02:58
 */
public class GreatestSumDivisibleByThree{
    public static void main(String[] args) {
        Solution solution = new GreatestSumDivisibleByThree().new Solution();
        System.out.println(solution.maxSumDivThree(new int[]{4}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumDivThree(int[] nums) {
        int base = 0;
        List<Integer> oneCount = new ArrayList<>();
        List<Integer> twoCount = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            base += nums[i];
            if (nums[i] % 3 == 1) {
                oneCount.add(nums[i]);
            }
            if (nums[i] % 3 == 2) {
               twoCount.add(nums[i]);
            }
        }
        if (base % 3 == 0) {
            return base;
        }
        Collections.sort(oneCount);
        Collections.sort(twoCount);
        if (base % 3 == 2) { // swap(a1,a2)
            List<Integer> tmp = oneCount;
            oneCount = twoCount;
            twoCount = tmp;
        }
        int ans = oneCount.isEmpty() ? 0 : base - oneCount.get(0);
        if (twoCount.size() > 1)
            ans = Math.max(ans, base - twoCount.get(0) - twoCount.get(1));
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}