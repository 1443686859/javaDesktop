//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4729 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2022-05-04 11:59:10
 */
public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          if (i > 0 && nums[i - 1] == nums[i]) {
              continue;
          }
          if (nums[i] > 0) {
              continue;
          }
          int target = - nums[i];
          int right = n - 1;
          for (int j = i + 1; j < n; j++) {
              if (j > i + 1 && nums[j - 1] == nums[j]) {
                  continue;
              }
              while (j < right && nums[j] + nums[right] > target) {
                  right --;
              }
              if (j == right) {
                  break;
              }
              if (nums[j] + nums[right] == target) {
                  result.add(Arrays.asList(nums[i], nums[j], nums[right]));
              }
          }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}