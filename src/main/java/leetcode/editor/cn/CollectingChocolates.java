//给你一个长度为 n 、下标从 0 开始的整数数组 nums ，表示收集不同巧克力的成本。每个巧克力都对应一个不同的类型，最初，位于下标 i 的巧克力就对应第
// i 个类型。 
//
// 在一步操作中，你可以用成本 x 执行下述行为： 
//
// 
// 同时修改所有巧克力的类型，将巧克力的类型 iᵗʰ 修改为类型 ((i + 1) mod n)ᵗʰ。 
// 
//
// 假设你可以执行任意次操作，请返回收集所有类型巧克力所需的最小成本。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [20,1,15], x = 5
//输出：13
//解释：最开始，巧克力的类型分别是 [0,1,2] 。我们可以用成本 1 购买第 1 个类型的巧克力。
//接着，我们用成本 5 执行一次操作，巧克力的类型变更为 [1,2,0] 。我们可以用成本 1 购买第 2 个类型的巧克力。
//然后，我们用成本 5 执行一次操作，巧克力的类型变更为 [2,0,1] 。我们可以用成本 1 购买第 0 个类型的巧克力。
//因此，收集所有类型的巧克力需要的总成本是 (1 + 5 + 1 + 5 + 1) = 13 。可以证明这是一种最优方案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], x = 4
//输出：6
//解释：我们将会按最初的成本收集全部三个类型的巧克力，而不需执行任何操作。因此，收集所有类型的巧克力需要的总成本是 1 + 2 + 3 = 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁹ 
// 1 <= x <= 10⁹ 
// 
//
// Related Topics 数组 枚举 👍 76 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-12-28 21:34:07
 */
public class CollectingChocolates{
    public static void main(String[] args) {
        Solution solution = new CollectingChocolates().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minCost(int[] nums, int x) {
        long min = 0;
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            min += nums[i];
            result[i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            long temp = 0;
            for (int j = 0; j < n; j++) {
                result[j] = Math.min(result[j], nums[(i + j) % n]);
                temp += result[j];
            }
            min = Math.min(temp + i * 1l * x, min);
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}