//给你两个正整数：n 和 target 。 
//
// 如果数组 nums 满足下述条件，则称其为 美丽数组 。 
//
// 
// nums.length == n. 
// nums 由两两互不相同的正整数组成。 
// 在范围 [0, n-1] 内，不存在 两个 不同 下标 i 和 j ，使得 nums[i] + nums[j] == target 。 
// 
//
// 返回符合条件的美丽数组所可能具备的 最小 和，并对结果进行取模 10⁹ + 7。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2, target = 3
//输出：4
//解释：nums = [1,3] 是美丽数组。
//- nums 的长度为 n = 2 。
//- nums 由两两互不相同的正整数组成。
//- 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
//可以证明 4 是符合条件的美丽数组所可能具备的最小和。 
//
// 示例 2： 
//
// 
//输入：n = 3, target = 3
//输出：8
//解释：
//nums = [1,3,4] 是美丽数组。 
//- nums 的长度为 n = 3 。 
//- nums 由两两互不相同的正整数组成。 
//- 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
//可以证明 8 是符合条件的美丽数组所可能具备的最小和。 
//
// 示例 3： 
//
// 
//输入：n = 1, target = 1
//输出：1
//解释：nums = [1] 是美丽数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 1 <= target <= 10⁹ 
// 
//
// Related Topics 贪心 数学 👍 14 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-03-08 03:16:30
 */
public class FindTheMinimumPossibleSumOfABeautifulArray{
    public static void main(String[] args) {
        Solution solution = new FindTheMinimumPossibleSumOfABeautifulArray().new Solution();
        System.out.println(solution.minimumPossibleSum(100000,
                1));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumPossibleSum(int n, int target) {
        int mod = 1_000_000_007;
        long start = Math.min(n, target / 2);
        long pre = (start * (start + 1)/ 2) % mod;
        long after = (((long) target * 2 + n - start - 1) * (n - start) / 2) % mod;
        return  (int)((after + pre) % mod);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}