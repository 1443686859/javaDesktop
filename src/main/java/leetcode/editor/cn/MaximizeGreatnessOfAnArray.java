//给你一个下标从 0 开始的整数数组 nums 。你需要将 nums 重新排列成一个新的数组 perm 。 
//
// 定义 nums 的 伟大值 为满足 0 <= i < nums.length 且 perm[i] > nums[i] 的下标数目。 
//
// 请你返回重新排列 nums 后的 最大 伟大值。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,3,5,2,1,3,1]
//输出：4
//解释：一个最优安排方案为 perm = [2,5,1,3,3,1,1] 。
//在下标为 0, 1, 3 和 4 处，都有 perm[i] > nums[i] 。因此我们返回 4 。 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4]
//输出：3
//解释：最优排列为 [2,3,4,1] 。
//在下标为 0, 1 和 2 处，都有 perm[i] > nums[i] 。因此我们返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// 👍 0 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-03-19 06:52:30
 */
public class MaximizeGreatnessOfAnArray{
    public static void main(String[] args) {
        Solution solution = new MaximizeGreatnessOfAnArray().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximizeGreatness(int[] nums) {
        int n = nums.length;
        int[][] index = new int[n][2];
        for (int i = 0; i < n; i++) {
            index[i][0] = nums[i];
            index[i][1] = i;
        }
        Arrays.sort(index, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}