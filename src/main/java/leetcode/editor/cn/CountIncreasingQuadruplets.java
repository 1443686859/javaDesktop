/**
给你一个长度为 n 下标从 0 开始的整数数组 nums ，它包含 1 到 n 的所有数字，请你返回上升四元组的数目。 

 如果一个四元组 (i, j, k, l) 满足以下条件，我们称它是上升的： 

 
 0 <= i < j < k < l < n 且 
 nums[i] < nums[k] < nums[j] < nums[l] 。 
 

 

 示例 1： 

 输入：nums = [1,3,2,4,5]
输出：2
解释：
- 当 i = 0 ，j = 1 ，k = 2 且 l = 3 时，有 nums[i] < nums[k] < nums[j] < nums[l] 。
- 当 i = 0 ，j = 1 ，k = 2 且 l = 4 时，有 nums[i] < nums[k] < nums[j] < nums[l] 。
没有其他的四元组，所以我们返回 2 。
 

 示例 2： 

 输入：nums = [1,2,3,4]
输出：0
解释：只存在一个四元组 i = 0 ，j = 1 ，k = 2 ，l = 3 ，但是 nums[j] < nums[k] ，所以我们返回 0 。
 

 

 提示： 

 
 4 <= nums.length <= 4000 
 1 <= nums[i] <= nums.length 
 nums 中所有数字 互不相同 ，nums 是一个排列。 
 

 👍 76 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-09-10 19:03:41
 */
public class CountIncreasingQuadruplets{
    public static void main(String[] args) {
        Solution solution = new CountIncreasingQuadruplets().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countQuadruplets1(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int[][] greatC = new int[n][n + 1];
        for (int i = n - 2; i > 0; i--) {
            greatC[i] = greatC[i + 1].clone();
            for (int j = 1; j < nums[i + 1]; j++) {
                greatC[i][j]++;
            }
        }
        for (int i = 1; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] > nums[j]) {
                   ans += (nums[j] - (n - 1 - i - greatC[i][nums[j]])) * greatC[j][nums[i]];
                }
            }
        }
        return ans;
    }
    public long countQuadruplets(int[] nums) {
        long ans4 = 0;
        int n = nums.length;
        int[] ans3 = new int[n];
        for (int l = 2; l < n; l++) {
            int ans2 = 0;
            for (int k = 0; k < l; k++) {
                if (nums[l] > nums[k]) {
                    ans2++;
                    ans4 += ans3[k];
                } else {
                    ans3[k] += ans2;
                }
            }
        }
        return ans4;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}