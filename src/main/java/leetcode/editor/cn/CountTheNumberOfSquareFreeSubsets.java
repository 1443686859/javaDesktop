//给你一个正整数数组 nums 。 
//
// 如果数组 nums 的子集中的元素乘积是一个 无平方因子数 ，则认为该子集是一个 无平方 子集。 
//
// 无平方因子数 是无法被除 1 之外任何平方数整除的数字。 
//
// 返回数组 nums 中 无平方 且 非空 的子集数目。因为答案可能很大，返回对 10⁹ + 7 取余的结果。 
//
// nums 的 非空子集 是可以由删除 nums 中一些元素（可以不删除，但不能全部删除）得到的一个数组。如果构成两个子集时选择删除的下标不同，则认为这两个
//子集不同。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,4,5]
//输出：3
//解释：示例中有 3 个无平方子集：
//- 由第 0 个元素 [3] 组成的子集。其元素的乘积是 3 ，这是一个无平方因子数。
//- 由第 3 个元素 [5] 组成的子集。其元素的乘积是 5 ，这是一个无平方因子数。
//- 由第 0 个和第 3 个元素 [3,5] 组成的子集。其元素的乘积是 15 ，这是一个无平方因子数。
//可以证明给定数组中不存在超过 3 个无平方子集。 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
//解释：示例中有 1 个无平方子集：
//- 由第 0 个元素 [1] 组成的子集。其元素的乘积是 1 ，这是一个无平方因子数。
//可以证明给定数组中不存在超过 1 个无平方子集。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 30 
// 
//
// 👍 18 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-02-24 21:30:49
 */
public class CountTheNumberOfSquareFreeSubsets{
    public static void main(String[] args) {
        Solution solution = new CountTheNumberOfSquareFreeSubsets().new Solution();
        System.out.println(solution.squareFreeSubsets(new int[]{1}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int squareFreeSubsets(int[] nums) {
        int mod = (int)1e9 + 7;
        List<Integer> primes = Arrays.asList(1,2,3,5,7,11,13,17,19,21,23,29);
        List<Integer> current = Arrays.asList(4,9,16, 25);
        int[] count = new int[31];
        for (int i : nums) {
            if (primes.contains(i)) {
                count[i]++;
            }
        }
        int result = 1;
        for (int i : count) {
            if (i != 0) {
                result = (result % mod * (i + 1) % mod) % mod;
            }
        }
        return result - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}