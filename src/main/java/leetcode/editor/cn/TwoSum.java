//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//
// Related Topics 数组 哈希表 👍 18345 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-03-04 20:27:23
 */
public class TwoSum{
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] n = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            n[i][0] = nums[i];
            n[i][1] = i;
        }
        Arrays.sort(n, (a,b) ->  a[0] - b[0]);
        int pre = 0;
        int index = nums.length - 1;
        int[] result = new int[2];
        while (pre < index) {
            if (n[pre][0] + n[index][0] < target) {
                pre++;
            } else if (n[pre][0] + n[index][0] > target) {
                index--;
            } else {
                result[0] = n[pre][1];
                result[1] = n[index][1];;
                break;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}