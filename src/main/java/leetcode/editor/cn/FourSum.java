//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1664 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-07-15 21:31:33
 */
public class FourSum{
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        System.out.println(solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
       for (int left = 0; left < nums.length - 3; left ++) {
           if (left > 0 && nums[left - 1] == nums[left]) {
               continue;
           }
           for (int j = left + 1; j < nums.length - 2; j++) {
               if (j > left + 1 && nums[j - 1] == nums[j]) {
                   continue;
               }
               long current = 0l + target - nums[left] - nums[j];
               if (current > nums[nums.length - 1] + nums[nums.length - 2]) {
                   continue;
               } else if (current < nums[j + 1] + nums[j + 2]) {
                   break;
               }
                int start = j + 1;
               int end = nums.length - 1;
               while (start < end) {
                   if (nums[start] + nums[end] < current) {
                       start++;
                   } else if (nums[start] + nums[end] > current) {
                       end--;
                   } else {
                       result.add(Arrays.asList(nums[left], nums[j], nums[start], nums[end]));
                       for (end --; start < end && nums[end] == nums[end + 1]; end--) ;
                       for (start ++; start < end && nums[start] == nums[start -  1]; start++) ;
                   }
               }

           }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}