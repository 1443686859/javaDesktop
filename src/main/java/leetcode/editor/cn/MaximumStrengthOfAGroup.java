/**
给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值 最大
，如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[i2
] * ... * nums[ik] 。 

 请你返回老师创建的小组能得到的最大实力值为多少。 

 

 示例 1： 

 输入：nums = [3,-1,-5,2,5,-9]
输出：1350
解释：一种构成最大实力值小组的方案是选择下标为 [0,2,3,4,5] 的学生。实力值为 3 * (-5) * 2 * 5 * (-9) = 1350 ，这是可
以得到的最大实力值。
 

 示例 2： 

 输入：nums = [-4,-5,-4]
输出：20
解释：选择下标为 [0, 1] 的学生。得到的实力值为 20 。我们没法得到更大的实力值。
 

 

 提示： 

 
 1 <= nums.length <= 13 
 -9 <= nums[i] <= 9 
 

 👍 54 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-09-03 20:11:02
 */
public class MaximumStrengthOfAGroup{
    public static void main(String[] args) {
        Solution solution = new MaximumStrengthOfAGroup().new Solution();
        System.out.println(solution.maxStrength(new int[]{2,2,7,0,-4,9,4}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxStrength(int[] nums) {
        long mx = nums[0];
        long mn = mx;
        for (int i = 1; i < nums.length; i++) {
            long temp = mn;
            mn = Math.min(Math.min(mn, nums[i]), Math.min(mx * nums[i], mn * nums[i]));
            mx = Math.max(Math.max(mx, nums[i]), Math.max(mx * nums[i], temp * nums[i]));

        }
        return mx;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}