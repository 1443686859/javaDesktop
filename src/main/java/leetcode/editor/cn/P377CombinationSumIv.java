package leetcode.editor.cn;
//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。 
//
// 题目数据保证答案符合 32 位整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9], target = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// nums 中的所有元素 互不相同 
// 1 <= target <= 1000 
// 
//
// 
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
// Related Topics 数组 动态规划 👍 567 👎 0

public class P377CombinationSumIv{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum4(new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}, 10));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] count = new int[target + 1];
            int n = nums.length;
             for (int i = 1; i < count.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (i - nums[j] > 0 && count[i - nums[j]] != 0) {
                        count[i] += count[i - nums[j]];
                    }
                }
            }
            return count[target];

        }

}
//leetcode submit region end(Prohibit modification and deletion)

}